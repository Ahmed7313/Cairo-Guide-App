package com.example.android.tryproject.com.appContent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tryproject.Place;
import com.example.android.tryproject.R;
import com.example.android.tryproject.placeAdapter;
import com.example.android.tryproject.place_detailes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MosquesFragment extends Fragment {


    public MosquesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.al_azhar, "Al-Azhar Mosque", "opens all the time",
                "Al-Azhar Mosque is an Egyptian mosque in Islamic Cairo.", "geo:30.032562, 31.256203\n" +
                "\n", "tel:45345354645", "http://koshary-eltahrir.com/"
                , getString(R.string.al_azhar)));

        places.add(new Place(R.drawable.sultan_h_madrasah, "Sultan Hassan Madrasah", "opens at 9 o'clock",
                "The Mosque-Madrassa of Sultan Hassan is a massive mosque and madrassa located in the Old city of Cairo",
                "geo:30.029080, 31.259514\n" +
                        "\n", "tel: 0100 734 2507",
                "http://www.touregypt.net/featurestories/hassanmosque.htm",
                getString(R.string.sultan_hassa_madrasah)));

        places.add(new Place(R.drawable.el_hussain, "Al-Hussein Mosque", "opens all the time",
                "The Al-Hussain Mosque is a mosque built in 1154 The mosque is located in Cairot.",
                "geo: 30.048111, 31.262997\n" +
                        "\n,?z=18", "tel: 011 54245465654", "https://www.memphistours.co.uk/Egypt/Egypt-Travel-Guide/Cairo-Attractions/wiki/Mosque-of-Saiyidna-Hussein",
                getString(R.string.al_hussin)));

        placeAdapter adapter = new placeAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                //create a new intent to open the place_detaile activity that will show the complete informaton about the place
                Intent intent = new Intent(MosquesFragment.this.getActivity(), place_detailes.class);
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
        return rootView;
    }

}
