package com.example.android.tryproject.com.appContent;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tryproject.R;

public class ActivityContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        int defaultValue = 0;
        int page = getIntent().getIntExtra(getString(R.string.zero), defaultValue);
        int page1 = getIntent().getIntExtra(getString(R.string.one), defaultValue);
        int page2 = getIntent().getIntExtra(getString(R.string.tow), defaultValue);
        int page3 = getIntent().getIntExtra(getString(R.string.three), defaultValue);


        viewPager.setCurrentItem(page);
        viewPager.setCurrentItem(page1);
        viewPager.setCurrentItem(page2);
        viewPager.setCurrentItem(page3);

    }
}