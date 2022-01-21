package com.example.travel_blog_testa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class BlogDetailsActivity extends AppCompatActivity {


    private TextView textTitle;
    private TextView textDate;
    private TextView textAuthor;
    private TextView textRating;
    private TextView textDescription;
    private TextView textViews;
    private RatingBar ratingBar;
    private ImageView imageAvatar;
    private ImageView imageMain;


    //protected is an access modifier for the onCreate method, means it can be accessed within the class itself, and through object references.
    //testing branch

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);


        imageMain = findViewById(R.id.imageMain);
        imageAvatar = findViewById(R.id.imageAvatar);

        ImageView imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(v -> finish());


        //code below hooks up layout views to this activity so they can be displayed
        textTitle = findViewById(R.id.textTitle);

        textDate = findViewById(R.id.textDate);

        textAuthor = findViewById(R.id.textAuthor);

        textRating = findViewById(R.id.textRating);

        textViews = findViewById(R.id.textViews);

        textDescription = findViewById(R.id.textDescription);

        ratingBar = findViewById(R.id.ratingBar);


//        //load data
//        loadData();





    }
}