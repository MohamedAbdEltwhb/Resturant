package com.example.mm.resturant.models.sharedpreferenceshelber;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mm.resturant.models.SQLiteHelper.UserTable.DataBaseHelper;

import static android.content.Context.MODE_PRIVATE;

public class OrderStorage {

    //private DataBaseHelper helper;

    public static final String MY_PREFS_ORDER = "MY_PREFS_ORDER";

    private static final String VISITOR_NAME = "VisitorName";
    SharedPreferences mSharedPreferences;

    public OrderStorage(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS_ORDER, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void putVisitorName(String visitorName) {

        mSharedPreferences.edit().putString(VISITOR_NAME, visitorName).apply();
    }

    public String getVisitorName() {
        return mSharedPreferences.getString(VISITOR_NAME, null);
    }

}
