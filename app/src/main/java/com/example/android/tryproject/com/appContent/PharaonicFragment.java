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
import com.example.android.tryproject.PlaceAdapter;
import com.example.android.tryproject.R;
import com.example.android.tryproject.place_detailes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PharaonicFragment extends Fragment {


    public PharaonicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.pyramids_of_giza, getString(R.string.pyramids_name), getString(R.string.opens_all_the_time),
                getString(R.string.pyramids_info), getString(R.string.pyramids_location), getString(R.string.pyramids_phone), getString(R.string.pyramids_websit),
                getString(R.string.pyramids_of_giza)));

        places.add(new Place(R.drawable.colossus_of_ramses_ii, getString(R.string.mit_rahina_name), getString(R.string.opens_at_9),
                getString(R.string.mit_rahina_info), getString(R.string.mit_rahina_location), getString(R.string.mit_rahina_phone),
                getString(R.string.mit_rahina_websit),
                getString(R.string.ramsis)));

        places.add(new Place(R.drawable.dahshur, getString(R.string.dahsour_name), getString(R.string.opens_at_9),
                getString(R.string.dashour_info),
                getString(R.string.dahsour_location), getString(R.string.dahsour_phone), getString(R.string.dahsour_website),
                getString(R.string.dahshour)));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                //create a new intent to open the place_detaile activity that will show the complete informaton about the place
                Intent intent = new Intent(PharaonicFragment.this.getActivity(), place_detailes.class);
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
