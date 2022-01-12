package com.example.travel_blog_testa.http;

//This is the class responsible for making network calls using

//The BlogHttpClient class is defined as "final" and its contructor is declared as "private"
//because there should only be 1 instance of the BlogHttpClient class across the ENTIRE application

import com.google.gson.Gson;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;

public final class BlogHttpClient {



    //object instance is accessed using INSTANCE
    public static final BlogHttpClient INSTANCE = new BlogHttpClient();

    private static final String BASE_URL =
            "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/";

    private static final String BLOG_ARTICLES_URL =
            BASE_URL + "8550ef2064bf14fcf3b9ff322287a2e056c7e153/blog_articles.json";



    private Executor executor;
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


}
