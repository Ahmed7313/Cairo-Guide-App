package com.example.android.tryproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class place_detailes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detailes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle bundle = getIntent().getExtras();
        int placeImage = bundle.getInt("placeImage");
        String placeName = bundle.getString("placeName");
        String placeInformation = bundle.getString("placeInformation");
        final String placePhone = bundle.getString("placePhone");
        final String placeLocation = bundle.getString("placeLocation");
        final String placeWebsite = bundle.getString("placeWbsite");
        String PlaceInformationDetaled = bundle.getString("PlaceInformationDetaled");

        ImageView placeImageDetailes = findViewById(R.id.place_image_detailes);
        placeImageDetailes.setImageResource(placeImage);

        setTitle(placeName);

        TextView placeInformationDetailes = findViewById(R.id.place_Information_detailes);
        placeInformationDetailes.setText(PlaceInformationDetaled);

        //opens the location of the place in the google maps when hit the location icon
        ImageView directon = findViewById(R.id.direction);
        directon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Map point based on address
                // Or map point based on latitude/longitude
                // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
                // Build the intent
                Uri location = Uri.parse(placeLocation);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(mapIntent);
                }
            }
        });

        //opens the the dialer with the number of the place or site
        ImageView phone = findViewById(R.id.call);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse(placePhone);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(callIntent);
                }
            }
        });

        //opens the location of the place in the google maps when hit the location icon
        ImageView web = findViewById(R.id.website);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Map point based on address
                // Or map point based on latitude/longitude
                // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
                // Build the intent
                Uri location = Uri.parse(placeWebsite);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(mapIntent);
                }
            }
        });

    }
}
