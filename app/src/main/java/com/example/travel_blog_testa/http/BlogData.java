package com.example.travel_blog_testa.http;

import com.example.travel_blog_testa.http.Blog;

//This object will hold an array of blog articles

import java.util.ArrayList;
import java.util.List;

public class BlogData {

    private List<Blog> data;

    public List<Blog> getData() {

        //basically says, "if data passed in is not empty, return the list of blog article data
        return data != null ? data : new ArrayList<Blog>();
    }


}
