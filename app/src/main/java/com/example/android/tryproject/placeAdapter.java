package com.example.android.tryproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeAdapter extends ArrayAdapter<Place> {

    public placeAdapter(@NonNull Context context, @NonNull ArrayList<Place> sampleArrayList) {
        super(context, 0, sampleArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View listitemview = convertView;
        if (listitemview == null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.place_body, parent, false);
        }
        //Get the object of AdapterBody at the position that is located in this list
        Place place = getItem(position);
        //get the image of the palceimage from the AdapterBody class and set it in the next position position
        ImageView placeImage = listitemview.findViewById(R.id.placeImage);
        placeImage.setImageResource(place.getPlaceImage());
        //get the text of the palceName from the AdapterBody class and set it in the next position position
        TextView placeText = listitemview.findViewById(R.id.placeName);
        placeText.setText(place.getPlaceName());
        //set the text for open or close
        TextView statues = listitemview.findViewById(R.id.placeStatues);
        statues.setText(place.getStatues());
        //get the text of the PlaceInformation from the AdapterBody class and set it in the next position position
        TextView placeInformation = listitemview.findViewById(R.id.placeInformation);
        placeInformation.setText(place.getPlaceInformation());
        //know if the place is opened or close

        return listitemview;
    }
}

