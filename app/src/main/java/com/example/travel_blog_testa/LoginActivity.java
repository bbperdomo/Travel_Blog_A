package com.example.travel_blog_testa;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordLayout;
    private Button loginButton;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //connects LoginActivity to activity_login.xml

        //binding views from xml to java objects using "findViewById()" method
        textUsernameLayout = findViewById(R.id.textUsernameLayout;
        textPasswordLayout = findViewById(R.id.textPasswordInput;
        loginButton = findViewById(R.id.loginButton;

    }

}
