package com.example.risbo.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class BrowseActivity extends AppCompatActivity {
    private float rating;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Intent intent = getIntent();
        rating = intent.getFloatExtra("rating", 0);

    }

    public void onPhotoClick(View view) {

        String friendsName = view.getTag().toString();

        Intent intent = new Intent(this,DetailsActivity.class);
        intent.putExtra("friendsName",friendsName);
        intent.putExtra("rating",rating);
        startActivity(intent);




    }


}
