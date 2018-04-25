package com.example.android.tryproject;

public class Place {
    public static int IS_FAVORITE = -1;
    private int placeImage;
    private String placeName;
    private String placeInformation;
    private String statues;
    private int checkFavorite = IS_FAVORITE;

    public Place (int placeImage, String placeName, String statues, String placeInformation) {
        this.placeImage = placeImage;
        this.placeName = placeName;
        this.placeInformation = placeInformation;
        this.statues = statues;
    }

    public static int getIS_FAVORITE() {
        return IS_FAVORITE;
    }

    public int getPlaceImage() {
        return placeImage;
    }

    public String getPlaceInformation() {
        return placeInformation;
    }

    public String getStatues() {
        return statues;
    }

    public int getCheckFavorite() {
        return checkFavorite;
    }

    public String getPlaceName() {
        return placeName;
    }

}
