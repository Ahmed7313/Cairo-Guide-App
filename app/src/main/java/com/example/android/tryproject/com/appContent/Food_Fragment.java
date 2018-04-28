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

        places.add(new Place(R.drawable.koshary_el_tahrear, getString(R.string.koshary_eltahrear), "opens at 10 ap till 1 pm",
                "one of the most famous Egyptian food ever", "geo:29.979487, 31.134250\n" +
                "\n", "tel:19719", "http://koshary-eltahrir.com/"
                , getString(R.string.kushary_detailed)));

        places.add(new Place(R.drawable.kabab, "Kabab", "opens at 9 oclock",
                "Kebabs (also kabobs or kababs) are various cooked meat dishes, with their origins in Middle Eastern cuisine", "geo:30.029080, 31.259514\n" +
                "\n", "tel: 0100 734 2507",
                "https://www.elmenus.com/ar/cairo/search-%D9%85%D8%B4%D9%88%D9%8A%D8%A7%D8%AA?delivery=1&isopen=0",
                getString(R.string.kabab_details)));

        places.add(new Place(R.drawable.flafel, "Flafel", "opens at 8 ocklock",
                "Falafel is a common food eaten in the Middle East.",
                "geo: 30.052484, 31.262578\n" +
                        "\n,?z=18", "tel: 011 54265654", "https://www.facebook.com/s7emy.house/",
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
