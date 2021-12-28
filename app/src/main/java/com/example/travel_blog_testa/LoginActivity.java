package com.example.travel_blog_testa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    //data validation variables
    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordInput;
    private Button loginButton;
    private ProgressBar progressBar;

    //shared preferences
    private BlogPreferences preferences;

    @Override //added later
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        preferences = new BlogPreferences(this); //creates a shared preference, calls constructor
        if (preferences.isLoggedIn()) { //If isloggedin returns a login_state(true), start main activity
            startMainActivity();
            finish();
            return;
        }

        setContentView(R.layout.activity_login); //connects LoginActivity to activity_login.xml

        //binding views from xml to java objects using "findViewById()" method
        textUsernameLayout = findViewById(R.id.textUsernameLayout);
        textPasswordInput = findViewById(R.id.textPasswordInput);
        loginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);


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

        //logic to execute text watcher
        textUsernameLayout
                .getEditText()
                .addTextChangedListener(createTextWatcher(textUsernameLayout));

        textPasswordInput
                .getEditText()
                .addTextChangedListener(createTextWatcher(textPasswordInput));


    }



    //text watcher that, uh watches out for changes in input field
    private TextWatcher createTextWatcher(TextInputLayout textPasswordInput) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textPasswordInput.setError(null); //clears the error message when text is added
            }

            @Override
            public void afterTextChanged(Editable s) {
                //not needed
            }

        };
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
        } else if (!username.equals("admin") && !password.equals("admin")) {

            showErrorDialog();
        }
        else {
            performLogin();
        }

    }



    //error log when credentials dont equal admin
    private void showErrorDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Login Failed")
                .setMessage("Username or password is not correct. Please try again.")
                .setPositiveButton("Ok", (dialog, which) -> dialog.dismiss())
                .show();
    }


    private void performLogin() {
        textUsernameLayout.setEnabled(false);
        textPasswordInput.setEnabled(false);
        //when creds == admin, login button is hidden, and progressbar is shown
        loginButton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        //Hnadler is an object which is tied to the looper of the thread in which its been created
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startMainActivity();
            finish(); // makes sure when back is pressed, progressBar is gone
        }, 2000);
    }

    //method that starts main activity
    //package content can be "this", since the Activity class implements the Context interface\
    //***Intent MUST be used to launch to another screen
    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
