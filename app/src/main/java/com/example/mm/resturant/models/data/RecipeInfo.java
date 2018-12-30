package com.example.mm.resturant.models.data;

public final class RecipeInfo {

    private String FoodName;
    private int plateImage,
                minutesNumber,
                nutritionsNumber,
                imageLikes,
                likesNumber,
                sharesNumber;

    public RecipeInfo(String foodName, int plateImage, int minutesNumber,
                      int nutritionsNumber, int imageLikes,
                      int likesNumber, int sharesNumber) {
        FoodName = foodName;
        this.plateImage = plateImage;
        this.minutesNumber = minutesNumber;
        this.nutritionsNumber = nutritionsNumber;
        this.imageLikes = imageLikes;
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

    public int getImageLikes() {
        return imageLikes;
    }

    public int getLikesNumber() {
        return likesNumber;
    }

    public int getSharesNumber() {
        return sharesNumber;
    }
}
