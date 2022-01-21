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


        ImageView imageMain = findViewById(R.id.imageMain);
        ImageView imageAvatar = findViewById(R.id.imageAvatar);


        //code below hooks up layout views to this activity so they can be displayed
        TextView textTitle = findViewById(R.id.textTitle);
        textTitle.setText("Singing tunes in Thun");

        TextView textDate = findViewById(R.id.textDate);
        textDate.setText("January 11th, 2022");

        TextView textAuthor = findViewById(R.id.textAuthor);
        textAuthor.setText("Marc Schneider");

        TextView textRating = findViewById(R.id.textRating);
        textRating.setText("4.4");

        TextView textViews = findViewById(R.id.textViews);
        textViews.setText("(1459 views)");

        TextView textDescription = findViewById(R.id.textDescription);
        textDescription.setText("The name of the city derives from the Celtic term Dunum, meaning “fortified city.");

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(4.4f);


        ImageView imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(v -> finish());





    }
}