package com.example.travel_blog_testa;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.travel_blog_testa.http.Blog;
import com.example.travel_blog_testa.http.BlogHttpClient;
import com.example.travel_blog_testa.http.BlogArticlesCallback;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

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

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);

        imageMain = findViewById(R.id.imageMain);
        imageAvatar = findViewById(R.id.imageAvatar);

        ImageView imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(v -> finish());

        textTitle = findViewById(R.id.textTitle);
        textDate = findViewById(R.id.textDate);
        textAuthor = findViewById(R.id.textAuthor);
        textRating = findViewById(R.id.textRating);
        textViews = findViewById(R.id.textViews);
        textDescription = findViewById(R.id.textDescription);
        ratingBar = findViewById(R.id.ratingBar);

        //binds progressBar view from xml to this Class
        progressBar = findViewById(R.id.progressBar);

        loadData();
    }


    //Class that triggers BlogHttpClient methods and returns a list of blog articles
    private void loadData() {
        BlogHttpClient.INSTANCE.loadBlogArticles(new BlogArticlesCallback() {
            @Override

            //BlogArticleCallback interfaces methods are called
            public void onSuccess(List<Blog> blogList) {
                //if loadBlogArticles was successful, display data, also run on main thread
                runOnUiThread(() -> showData(blogList.get(0)));
            }

            @Override
            public void onError() {
                // handle error
                runOnUiThread(() -> showErrorSnackbar());

            }
        });
    }


    //displays blog articles to screen
    private void showData(Blog blog) {
        progressBar.setVisibility(View.GONE); //hides progress bar
        textTitle.setText(blog.getTitle());
        textDate.setText(blog.getDate());
        textAuthor.setText(blog.getAuthor().getName());
        textRating.setText(String.valueOf(blog.getRating()));
        textViews.setText(String.format("(%d views)", blog.getViews()));
        textDescription.setText((Html.fromHtml(blog.getDescription()))); //added Html creates styled text from html, also ignored tags
        ratingBar.setRating(blog.getRating());

        Glide.with(this)
                .load(blog.getImage())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageMain);

        Glide.with(this)
                .load(blog.getAuthor().getAvatar())
                .transform(new CircleCrop())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageAvatar);
    }

    //snack bar is a component from the materials library
    private void showErrorSnackbar() {

        View rootView = findViewById(android.R.id.content);

        Snackbar snackbar = Snackbar.make(rootView,
                "Error during loading blog articles", Snackbar.LENGTH_INDEFINITE);
        snackbar.setActionTextColor(getResources().getColor(R.color.orange500));
        snackbar.setAction("Retry", v -> {
            loadData();
            snackbar.dismiss();

        });
        snackbar.show();
    }

}