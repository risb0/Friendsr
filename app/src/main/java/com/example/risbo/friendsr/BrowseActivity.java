package com.example.risbo.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BrowseActivity extends AppCompatActivity {
    private float rating;
    private HashMap<String, Object> ratings_values;


    private String friendsName;
    private String PREFS_NAME = "ratingsPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Intent intent = getIntent();
        rating = intent.getFloatExtra("rating", 0);
        friendsName = intent.getStringExtra("friendsName");

        saveCurrentRating();

    }

    public void onPhotoClick(View view) {

        friendsName = view.getTag().toString();

        saveRatings(friendsName);

        Intent intent = new Intent(this,DetailsActivity.class);
        intent.putExtra("friendsName", friendsName);
        intent.putExtra("rating", rating);
        startActivity(intent);

    }

    public void saveCurrentRating () {

        ratings_values = new HashMap<>();
        ratings_values.put(friendsName, rating);

    }


    public void saveRatings(String friendsName) {

        //use a for-each loop and iterate through the map
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, 0).edit();
        for( Map.Entry<String, Object> entry : ratings_values.entrySet())
            editor.putFloat(entry.getKey(), (Float) entry.getValue());

        editor.commit();

        //get the values back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        for( Map.Entry<String, ?> entry : prefs.getAll().entrySet())
            ratings_values.put(entry.getKey(), entry.getValue());

        // save the rating for the current profile to send it in the Intent
        rating = Float.valueOf(ratings_values.get(friendsName).toString());

    }


}
