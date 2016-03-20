package com.example.risbo.friendsr;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import stanford.androidlib.SimpleActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private String friendName;
    private float rating;
    private SimpleActivity myActivity;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myActivity = (SimpleActivity) getActivity();


        if (friendName == null) {
            friendName = "Rachel";
        }


        setFriendsName(friendName);


    }

    public void setFriendsName(String friendsName) {

        myActivity = (SimpleActivity) getActivity();

        ImageView profileImageView = (ImageView) myActivity.findViewById(R.id.imageProfile);
        TextView profileNameTextView = (TextView) myActivity.findViewById(R.id.nameProfile);
        TextView profileDescriptionTextView = (TextView) myActivity.findViewById(R.id.descriptionProfile);


        profileNameTextView.setText(friendsName);



        int imageId = getResources().getIdentifier(friendsName.toLowerCase(),"drawable", myActivity.getPackageName());
        profileImageView.setImageResource(imageId);

        int descriptionId = getResources().getIdentifier(friendsName.toLowerCase(),"raw",myActivity.getPackageName());
        String profileDescription = myActivity.readFileText(descriptionId);
        profileDescriptionTextView.setText(profileDescription);

    }



    public void setRatingBar(float rating) {
        RatingBar ratingBar = (RatingBar) myActivity.findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);


    }


}
