package com.example.travel_blog_testa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//AppCompatActivity is the main component of AppCompat library, and is the base class that provides backwards compatibility for older android versiona
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is to bind the activity main layout to Main activity, this is layout binding
        setContentView(R.layout.activity_main);

        //this is an example of view binding.
        //to interact with views at runtime, you must bind the view from the xml file to a Java object, using the id attribute
        //Then you use the findviewbyid method
        TextView maintextView = findViewById(R.id.mainTextView);
        maintextView.setText("Hello Earth");
    }
}