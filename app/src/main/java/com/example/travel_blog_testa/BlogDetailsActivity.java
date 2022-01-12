package com.example.travel_blog_testa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BlogDetailsActivity extends AppCompatActivity {

    //protected is an access modifier for the onCreate method, means it can be accessed within the class itself, and through object references.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);


        ImageView imageMain = findViewById(R.id.imageMain);
        imageMain.setImageResource(R.drawable.thun_pic);

        ImageView imageAvatar = findViewById(R.id.imageAvatar);
        imageAvatar.setImageResource(R.drawable.marc_schneider);

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
    }
}