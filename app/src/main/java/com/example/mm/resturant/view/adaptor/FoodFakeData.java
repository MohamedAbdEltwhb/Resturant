package com.example.mm.resturant.view.adaptor;


import com.example.mm.resturant.R;
import com.example.mm.resturant.models.data.FoodInfo;

import java.util.ArrayList;
import java.util.List;

public class FoodFakeData {


    private static final List<FoodInfo> mRecipeFakeData = new ArrayList<FoodInfo>(){{


        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 70));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30, 90));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 120));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30, 111));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30,80));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 78));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30,114));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 87));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 150));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30, 89));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 99));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30,54));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30, 150));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 59));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 48));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30, 58));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 57));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30, 108));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120,  0, 30, 142));
        add(new FoodInfo("KAMAAGE UDON", R.drawable.d, 20, 120, 0, 30,241));
    }};

    public static List<FoodInfo> getmRecipeFakeData() {
        return mRecipeFakeData;
    }
}
