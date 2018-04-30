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

        places.add(new Place(R.drawable.al_azhar, getString(R.string.al_azhar_mosqe_name), getString(R.string.opens_all_the_time),
                getString(R.string.al_azhar_info), getString(R.string.al_azhar_location), getString(R.string.al_azhar_phone), getString(R.string.al_azhar_website)
                , getString(R.string.al_azhar)));

        places.add(new Place(R.drawable.sultan_h_madrasah, getString(R.string.sultan_hassan_name2), getString(R.string.opens_at_9),
                getString(R.string.sultan_hassan_info),
                getString(R.string.sultan_hassan_location), getString(R.string.sultanhassan_phone),
                getString(R.string.sultan_hassan_websit),
                getString(R.string.sultan_hassa_madrasah)));

        places.add(new Place(R.drawable.el_hussain, getString(R.string.el_hussin_name), getString(R.string.opens_all_the_time),
                getString(R.string.el_hussin_info),
                getString(R.string.el_hussin_location), getString(R.string.el_hussin_phone), getString(R.string.el_hussin_websit),
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
                bundle.putInt(getString(R.string.placeImage), place.getPlaceImage());
                bundle.putString(getString(R.string.placeName), place.getPlaceName());
                bundle.putString(getString(R.string.placeInformation), place.getPlaceInformation());
                bundle.putString(getString(R.string.placeLocation), place.getLocation());
                bundle.putString(getString(R.string.placePhone), place.getPlacePhone());
                bundle.putString(getString(R.string.placeWbsite), place.getPlaceWebsite());
                bundle.putString(getString(R.string.PlaceInformationDetaled), place.getPlaceInformationDetailed());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
