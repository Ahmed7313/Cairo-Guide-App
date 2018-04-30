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

import com.ms.square.android.expandabletextview.ExpandableTextView;

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
                Snackbar.make(view, getString(R.string.uner_work), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.action), null).show();
            }
        });

        Bundle bundle = getIntent().getExtras();
        int placeImage = bundle.getInt(getString(R.string.placeImage));
        String placeName = bundle.getString(getString(R.string.placeName));
        String placeInformation = bundle.getString(getString(R.string.placeInformation));
        final String placePhone = bundle.getString(getString(R.string.placePhone));
        final String placeLocation = bundle.getString(getString(R.string.placeLocation));
        final String placeWebsite = bundle.getString(getString(R.string.placeWbsite));
        String PlaceInformationDetaled = bundle.getString(getString(R.string.PlaceInformationDetaled));

        ExpandableTextView textView = findViewById(R.id.expand_text_view);
        textView.setText(PlaceInformationDetaled);

        ImageView placeImageDetailes = findViewById(R.id.place_image_detailes);
        placeImageDetailes.setImageResource(placeImage);

        setTitle(placeName);


        //opens the location of the place in the google maps when hit the location icon
        ImageView directon = findViewById(R.id.direction);
        directon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mape view show the exact location of the place using intent
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
