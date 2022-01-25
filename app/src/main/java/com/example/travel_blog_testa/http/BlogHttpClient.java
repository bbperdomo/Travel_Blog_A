package com.example.travel_blog_testa.http;

//This is the class responsible for making network calls using

//So what is a thread?

/*"A thread, in the context of Java, is the path followed when executing a program. All Java programs have at least one thread,
known as the main thread, which is created by the Java Virtual Machine (JVM) at the program’s start,
when the main() method is invoked with the main thread." */

//Whats a thread pool?

/* It is a group of fixed sized threads. A thread from the thread pool is pulled out and assigned a job by the service provider.
 After completion of the job, the thread is contained in the thread pool again. */

//The BlogHttpClient class is defined as "final" and its constructor is declared as "private"
//because there should only be 1 instance of the BlogHttpClient class across the ENTIRE application
//This is basically to save memory usage, as creating a thread for every new client/request is too resource intensive
//hover over httpclient for more info

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class BlogHttpClient {



    //object instance is accessed using INSTANCE
    public static final BlogHttpClient INSTANCE = new BlogHttpClient();

    private static final String BASE_URL =
            "https://bitbucket.org/dmytrodanylyk/travel-blog-resources";

    public static final String PATH = "/raw/3eede691af3e8ff795bf6d31effb873d484877be";

    //changing the urls allows me to concatenate the base url with the relative path of the blog image, or author avatar
    private static final String BLOG_ARTICLES_URL =
            BASE_URL + PATH +  "/blog_articles.json";



    private Executor executor;  //allows control of threading
    private OkHttpClient client;
    private Gson gson;

    //constructor method
    /*UI thread is the Main thread
    The UI thread is the only thread you can use to touch UI components
    ALL heavy workloads should be delegated to the background thread, NOT UI(Main) thread, to keep the UI responsive
    Once work in background thread is completed, use "runOnUiThread" method to switch to UI thread. */
    private BlogHttpClient() {

        //Executor runs network calls on the background thread, as to not block the UI thread (or Main Thread)
        //OkhttpClient makes the network calls
        //Gson parses JSON data
        executor = Executors.newFixedThreadPool(4);
        client = new OkHttpClient();
        gson = new Gson();



    }

    //The calling class will pass BlogArticlesCallBack into this load articles method
    /* loadData IS THE CALLING CLASS */
    //I think "callback" is an object of type BACallback, is used to reference its interface's methods
    public void loadBlogArticles(BlogArticlesCallback callback) {

        //request object, it defines the type of request and url
        //builds an okhttp GET request
        Request request = new Request.Builder()
        .get()
        .url(BLOG_ARTICLES_URL)
        .build();

        //executor allows us to execute code using background thread
        //i think we're using the executor object defined above with the fixed thread pool
        executor.execute(() -> {
            try {
                //executing OkHttp method newCall using request to retrieve a json response
                //client is the OkHttp object
                Response response = client.newCall(request).execute();

                //Once we retrieve the response, we use body() to get the body of the response
                ResponseBody responseBody = response.body();

                //check to see if we got a non-empty response
                if (responseBody != null) {

                    //transforms responseBody into a string(), which is an OkHttp method
                    String json = responseBody.string();

                    //converts the string of the json response body into an object of type BlogData
                    //DeSerializes json into Object
                    //which means, i think, that the json is converted into a list of data?
                    BlogData blogData = gson.fromJson(json, BlogData.class);

                    //if we retrieved some info...
                    if (blogData != null) {

                        //i think we passed the results returned from getData() (which is a list i think) into onSuccess
                        //onSuccess specifically takes a List object as a parameter
                        callback.onSuccess(blogData.getData());
                        return;
                    }
                }
                //in case of error
            } catch (IOException e) {
                Log.e("BlogHttpClient", "Error loading blog articles", e);
            }
            callback.onError();

        });
    }


}
