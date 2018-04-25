package com.example.android.tryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Things_to_do extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.egyptian_museum, "Egyptian Musiam Cairo", "opens at 9 oclock", "Tracing 5.000 years of ancient epyptian history"));
        places.add(new Place(R.drawable.mohamed_ali_mosqe, "Mohamed Ali Mosqe", "opens at 8 oclock", "Built in 18 centiries in the middle of Saladin casitle"));
        places.add(new Place(R.drawable.elsuhimi_house, "El Suhimi house", "opens at 10 ocklock", "An ancient house from the 5 centireis which located in Al mo'es streat"));

        placeAdapter adapter = new placeAdapter(this, places);

        ListView listView = findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);

                startActivity(new Intent(Things_to_do.this, place_detailes.class));

            }
        });
    }
}
