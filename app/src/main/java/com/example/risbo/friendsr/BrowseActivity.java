package com.example.risbo.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
    }

    public void onPhotoClick(View view) {

        Intent intent = new Intent(this,DetailsActivity.class);
        startActivity(intent);

    }


}
