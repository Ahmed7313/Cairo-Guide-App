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
public class Thing_To_do_Fragment extends Fragment {


    public Thing_To_do_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.egyptian_museum, getString(R.string.egyptian_museame_name), getString(R.string.opens_at_9), getString(R.string.egyptian_museame_info), getString(R.string.egyptian_museame_location), getString(R.string.egyptian_museame_pjone),
                getString(R.string.egyptian_museame_website), getString(R.string.egyptian_museame)));

        places.add(new Place(R.drawable.mohamed_ali_mosqe, getString(R.string.mohamed_ali_name), getString(R.string.opens_at_9),
                getString(R.string.mohamed_ali_info), getString(R.string.mohamed_ali_location), getString(R.string.mohamed_ali_phone),
                getString(R.string.mohamed_ali_websit),
                getString(R.string.mohamed_ali_detailed_info)));

        places.add(new Place(R.drawable.elsuhimi_house, getString(R.string.el_suhimi_house_name),
                getString(R.string.opens_at_9), getString(R.string.el_suhimi_house_info),
                getString(R.string.el_suhimi_house_location), getString(R.string.el_suhimi_house_phone),
                getString(R.string.el_suhimi_house_websit),
                getString(R.string.el_suhimi_house)));

        places.add(new Place(R.drawable.islamic_museum, getString(R.string.islamic_museum_title), getString(R.string.opens_at_9),
                getString(R.string.islamic_museum_information), getString(R.string.islamic_museum_location), getString(R.string.islamic_museum_phone), "https://www.miaegypt.org/",
                getString(R.string.islamic_museum_detaild_information)));

        placeAdapter adapter = new placeAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                //create a new intent to open the place_detaile activity that will show the complete informaton about the place
                Intent intent = new Intent(Thing_To_do_Fragment.this.getActivity(), place_detailes.class);
                //create a bundle that will transfer the data to the place_details activity
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
