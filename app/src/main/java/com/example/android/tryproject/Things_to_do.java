package com.example.android.tryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Things_to_do extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Thing_To_do_Fragment())
                .commit();
    }


}
