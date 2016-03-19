package com.example.risbo.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import stanford.androidlib.SimpleActivity;

public class DetailsActivity extends SimpleActivity implements RatingBar.OnRatingBarChangeListener {

    private String friendsName;
    private float rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView profileImageView = (ImageView) findViewById(R.id.imageProfile);
        TextView profileNameTextView = (TextView) findViewById(R.id.nameProfile);
        TextView profileDescriptionTextView = (TextView) findViewById(R.id.descriptionProfile);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Intent intent = getIntent();
        friendsName = intent.getStringExtra("friendsName");
        rating = intent.getFloatExtra("rating", 0);

        ratingBar.setRating(rating);
        profileNameTextView.setText(friendsName);

        ratingBar.setOnRatingBarChangeListener(this);
        
        int imageId = getResources().getIdentifier(friendsName.toLowerCase(),"drawable", getPackageName());
        profileImageView.setImageResource(imageId);

        int descriptionId = getResources().getIdentifier(friendsName.toLowerCase(),"raw",getPackageName());
        String profileDescription = readFileText(descriptionId);
        profileDescriptionTextView.setText(profileDescription);

    }


    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Intent intent = new Intent(this,BrowseActivity.class);
        rating = ratingBar.getRating();
        intent.putExtra("rating",rating);
        intent.putExtra("friendsName",friendsName);
        startActivity(intent);

        Toast.makeText(this, "You rated " + friendsName + " " + rating + " stars!", Toast.LENGTH_SHORT).show();

    }
}
