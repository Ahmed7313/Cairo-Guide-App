package com.example.android.tryproject;

public class Place {
    public static int IS_FAVORITE = -1;
    private int placeImage;
    private String placeName;
    private String placeInformation;
    private String placeInformationDetailed;
    private String statues;
    private String location;
    private String placePhone;
    private String placeWebsite;
    private int checkFavorite = IS_FAVORITE;

    public Place(int placeImage, String placeName, String statues, String placeInformation, String location, String placePhone,
                 String placeWebsite, String placeInformationDetailed) {
        this.placeImage = placeImage;
        this.placeName = placeName;
        this.placeInformation = placeInformation;
        this.statues = statues;
        this.location = location;
        this.placePhone = placePhone;
        this.placeWebsite = placeWebsite;
        this.placeInformationDetailed = placeInformationDetailed;
    }

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

    public String getLocation() {
        return location;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public String getPlaceWebsite() {
        return placeWebsite;
    }

    public String getPlaceInformationDetailed() {
        return placeInformationDetailed;
    }
}
