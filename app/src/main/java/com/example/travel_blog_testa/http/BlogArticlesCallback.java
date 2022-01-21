package com.example.travel_blog_testa.http;

import java.util.List;



//call back listener, which delivers the result to the calling class
//onSuccess returns a list of blog articles, and onError delivers an error
public interface BlogArticlesCallback {
    void onSuccess(List<Blog> blogList); //onSuccess takes a List of type Blog named blogList
    void onError();
}


/* SEQUENCE OF APPLICATION */
//1.)BlogDetailsActivity starts
//2.)BDA hooks up views to xml file
//3.) loadData() is called
//4.) BlogHttpClient is called (is instantiated)
//5.) BlogHttpClient instance is created, and loadBlogArticles() is called (from BlogHttpClient class)
//6.) BlogArticlesCallback() is passed into loadBlogArticles()
//7.)loadBlogArticles is executed. First, an OkHttp GET request is created
//8.) OkHttp client.newCall(request).execute() json response is stored in "response"
//9.) Body of response is converted to string, then Java object of type BlogData
    /*9a.)I think this is where each json element is hooked up to the members in the Blog class
//10.) At this point, I think json blog data is a list object of type Blog data */
//11.) getData() is called which passes our blog article list to onSuccess()
//12.) Now onSuccess() is called back in BlogDetailsActivity, which returns the list of Blog Articles!
//13.) showData is called on the blogList
//14.)getter methods from Blog class are called on elements from blogList and setText displays to the screen


/*SOME IMPORTANT NOTES/DEFINITONS */
//an Interface is like a class, its a collection of abstract methods. A class implements an interface
//To use an interface, it must be "implemented" or inherited
//BUT, an interface doesnt have contructors,
//cant create objects,
//and it caant be instantiated,






//so, the way loading data works:
//1.) models of data exist - Author, Blog, BlogData
//BlogHttpClient Class makes network calls
//-constructor sets up threads, Okhttp, and Gson
//-loadBlogArticles() builds a request, executes Okhttp request(newcall().execute()),
//-stores okhttp req in reponse var, converts json to Java object
//Callback listener returns list of blog articles