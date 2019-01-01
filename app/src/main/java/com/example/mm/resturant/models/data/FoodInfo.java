package com.example.mm.resturant.models.data;

public final class FoodInfo {

    private String FoodName;
    private int plateImage;


    private int minutesNumber;
    private int nutritionsNumber;
    private int likesNumber;
    private int sharesNumber;
    private int prise;

    public FoodInfo(String foodName, int plateImage, int minutesNumber,
                    int nutritionsNumber,
                    int likesNumber, int sharesNumber, int prise) {
        FoodName = foodName;
        this.plateImage = plateImage;
        this.minutesNumber = minutesNumber;
        this.nutritionsNumber = nutritionsNumber;
        this.likesNumber = likesNumber;
        this.sharesNumber = sharesNumber;
        this.prise = prise;
    }

    public String getFoodName() {
        return FoodName;
    }

    public int getPlateImage() {
        return plateImage;
    }

    public int getMinutesNumber() {
        return minutesNumber;
    }

    public int getNutritionsNumber() {
        return nutritionsNumber;
    }

    public int getLikesNumber() {
        return likesNumber;
    }

    public int getSharesNumber() {
        return sharesNumber;
    }


    public int getPrise() {
        return prise;
    }
}
