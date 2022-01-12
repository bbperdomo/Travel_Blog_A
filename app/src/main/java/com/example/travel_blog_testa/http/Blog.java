package com.example.travel_blog_testa.http;

//This is the Object that holds blog article information

public class Blog {

    //these are variables that reflect the data we want to extract from the JSON responses
    private String id;
    private Author author;
    private String title;
    private String date;
    private String image;
    private String description;
    private int views;
    private float rating;

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getViews() {
        return views;
    }

    public float getRating() {
        return rating;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }
}

}
