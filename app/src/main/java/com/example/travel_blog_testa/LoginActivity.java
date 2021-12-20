package com.example.travel_blog_testa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordInput;
    private Button loginButton;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //connects LoginActivity to activity_login.xml

        //binding views from xml to java objects using "findViewById()" method
        textUsernameLayout = findViewById(R.id.textUsernameLayout);
        textPasswordInput = findViewById(R.id.textPasswordInput);
        loginButton = findViewById(R.id.loginButton);


        loginButton = findViewById(R.id.loginButton);
        //setting click listener on login button using setOnCLickListener
        //OnClickListener() is an interface
        //When login button is clicked, onLoginClicked() is executed
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginActivity.this.onLoginClicked();
            }
        });


    }

    //validation and error messages
    private void onLoginClicked() {
        //not imp yet
        //getEditText retrieves reference to input field
        //getText retrieves actual text from input field that user types
        String username = textUsernameLayout.getEditText().getText().toString();
        String password = textPasswordInput.getEditText().getText().toString();

        if (username.isEmpty()) {
            textUsernameLayout.setError("Username must not be empty");

        } else if (password.isEmpty()) {
            textPasswordInput.setError("Password must not be empty");
        }

    }

}
