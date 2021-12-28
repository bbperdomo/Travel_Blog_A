package com.example.travel_blog_testa;

import android.content.Context;
import android.content.SharedPreferences;

public class BlogPreferences {

    private static final String KEY_LOGIN_STATE = "key_login_state";

    private SharedPreferences preferences;

    //Constructor - we create/get shared preferences
    BlogPreferences(Context context) {
        preferences =
                //getSharedPreferences is an android method
                //it has 2 params: name of app, and mode. private mode means only our app has access to these shared preferences
                context.getSharedPreferences("travel_blog_testa", Context.MODE_PRIVATE);
    }

    //retrieves the value from shared preferences
    public boolean isLoggedIn() {
        //getBoolean is one of shared preferences' get methods
        //key_login_state is the name of our preference
        return preferences.getBoolean(KEY_LOGIN_STATE, false);
    }

    //sets the value into shared preferences
    public void setLoggedIn(boolean loggedIn) {
        //the preferences.edit() method returns the "Editor" object, and this object has several put methods available.
        //apply() stores the data in memory to asynchronously persist on the file system.
        preferences.edit().putBoolean(KEY_LOGIN_STATE, loggedIn).apply();
    }

}
