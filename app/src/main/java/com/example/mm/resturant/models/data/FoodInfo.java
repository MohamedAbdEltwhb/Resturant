package com.example.mm.resturant.models.data;

public final class FoodInfo {

    private String FoodName;
    private int plateImage,
                minutesNumber,
                nutritionsNumber,
                likesNumber,
                sharesNumber;

    public FoodInfo(String foodName, int plateImage, int minutesNumber,
                    int nutritionsNumber,
                    int likesNumber, int sharesNumber) {
        FoodName = foodName;
        this.plateImage = plateImage;
        this.minutesNumber = minutesNumber;
        this.nutritionsNumber = nutritionsNumber;
        this.likesNumber = likesNumber;
        this.sharesNumber = sharesNumber;
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
}
