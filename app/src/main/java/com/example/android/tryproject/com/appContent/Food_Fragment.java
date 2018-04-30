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
public class Food_Fragment extends Fragment {


    public Food_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.drawable.koshary_el_tahrear, getString(R.string.koshary_eltahrear), getString(R.string.opens_at_9),
                getString(R.string.koshary_onformation), getString(R.string.koshary_location), getString(R.string.koshary_eltahreer__phone), getString(R.string.koshary_eltahreer_website)
                , getString(R.string.kushary_detailed)));

        places.add(new Place(R.drawable.kabab, getString(R.string.kabab_name), getString(R.string.opens_at_9),
                getString(R.string.kabab_info), getString(R.string.kabab_location), getString(R.string.kabab_pnone),
                getString(R.string.kabab_websit),
                getString(R.string.kabab_details)));

        places.add(new Place(R.drawable.flafel, getString(R.string.flafel_name), getString(R.string.opens_at_9),
                getString(R.string.flafel_info),
                getString(R.string.flafel_location), getString(R.string.flafel_phone), getString(R.string.flafel_websit),
                getString(R.string.flafel)));

        placeAdapter adapter = new placeAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                //create a new intent to open the place_detaile activity that will show the complete informaton about the place
                Intent intent = new Intent(Food_Fragment.this.getActivity(), place_detailes.class);
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
