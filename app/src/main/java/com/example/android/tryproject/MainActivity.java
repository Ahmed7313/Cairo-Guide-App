package com.example.android.tryproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.android.tryproject.com.appContent.ActivityContainer;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView thingToDo = findViewById(R.id.thing_to_do);
        thingToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page = 1;
                Intent intent = new Intent(MainActivity.this, ActivityContainer.class);
                intent.putExtra(getString(R.string.zero), page);// zero is your argument
                startActivity(intent);
            }
        });

        ImageView pharaonic = findViewById(R.id.phoronic);
        pharaonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page1 = 2;
                Intent intent = new Intent(MainActivity.this, ActivityContainer.class);
                intent.putExtra(getString(R.string.one), page1);// one is your argument
                startActivity(intent);
            }
        });

        ImageView food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page2 = 3;
                Intent intent = new Intent(MainActivity.this, ActivityContainer.class);
                intent.putExtra(getString(R.string.tow), page2);// tow is your argument
                startActivity(intent);
            }
        });

        ImageView mosques = findViewById(R.id.pyramamyds);
        mosques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page3 = 4;
                Intent intent = new Intent(MainActivity.this, ActivityContainer.class);
                intent.putExtra(getString(R.string.three), page3);// tow is your argument
                startActivity(intent);
            }
        });


        ImageView savedPlaces = findViewById(R.id.saved_places);
        savedPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.uner_work), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.action), null).show();
            }
        });
        ImageView thingsToKNow = findViewById(R.id.things_to_know);
        thingsToKNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.uner_work), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.action), null).show();
            }
        });

        ImageView gittingAround = findViewById(R.id.gitting_around);
        gittingAround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.uner_work), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.action), null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse(getString(R.string.intent_mail_type))); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.extra_subject));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.get_mail_intent)});

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
