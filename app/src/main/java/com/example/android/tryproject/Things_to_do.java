package com.example.android.tryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        places.add(new Place(R.drawable.egyptian_museum, "Egyptian Musiam Cairo", "opens at 9 oclock", "Tracing 5.000 years of ancient epyptian history", "geo:30.047968, 31.233809\n" +
                "\n,?z=18", "tel:02 25794596", "http://www.antiquities.gov.eg/DefaultEn/Museum/Pages/MuseumDetails.aspx?MusCode=28#", getString(R.string.egyptian_museame)));
        places.add(new Place(R.drawable.mohamed_ali_mosqe, "Mohamed Ali Mosqe", "opens at 8 oclock", "Built in 18 centiries in the middle of Saladin casitle", "geo:30.029080, 31.259514\n" +
                "\n", "tel: 555555", "https://www.marefa.org/%D9%85%D8%B3%D8%AC%D8%AF_%D9%85%D8%AD%D9%85%D8%AF_%D8%B9%D9%84%D9%8A", getString(R.string.mohamed_ali_detailed_info)));
        places.add(new Place(R.drawable.elsuhimi_house, "El Suhimi house", "opens at 10 ocklock", "An ancient house from the 5 centireis which located in Al mo'es streat", "geo: 30.052484, 31.262578\n" +
                "\n,?z=18", "tel: 011 54265654", "https://www.facebook.com/s7emy.house/", getString(R.string.el_suhimi_house)));

        placeAdapter adapter = new placeAdapter(this, places);

        ListView listView = findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                //create a new intent to open the place_detaile activity that will show the complete informaton about the place
                Intent intent = new Intent(Things_to_do.this, place_detailes.class);
                //create a bundle that will transfee the data to the place_detailes activity
                Bundle bundle = new Bundle();
                bundle.putInt("placeImage", place.getPlaceImage());
                bundle.putString("placeName", place.getPlaceName());
                bundle.putString("placeInformation", place.getPlaceInformation());
                bundle.putString("placeLocation", place.getLocation());
                bundle.putString("placePhone", place.getPlacePhone());
                bundle.putString("placeWbsite", place.getPlaceWebsite());
                bundle.putString("PlaceInformationDetaled", place.getPlaceInformationDetailed());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
