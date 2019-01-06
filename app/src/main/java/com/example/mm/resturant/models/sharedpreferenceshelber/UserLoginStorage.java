package com.example.mm.resturant.models.sharedpreferenceshelber;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class UserLoginStorage {

    public static final String MY_PREFS = "MY_PREFS";

    public static String KEY_EMAIL = "email";
    public static String KEY_PASSWORD = "password";

    public static String KEY_FNAME = "f_name";
    public static String KEY_LNAME = "l_name";
    public static String KEY_PHONE = "phone";

    //public static String KEY_IMAGE = "image";


    SharedPreferences mSharedPreferences;

    public UserLoginStorage(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void putEmail(String email) {
        mSharedPreferences.edit().putString(KEY_EMAIL, email).apply();
    }

    public String getEmail() {
        return mSharedPreferences.getString(KEY_EMAIL, null);
    }

    public void putPassword(String password) {
        mSharedPreferences.edit().putString(KEY_PASSWORD, password).apply();
    }

    public String getPassword() {
        return mSharedPreferences.getString(KEY_PASSWORD, null);
    }





//    public static boolean saveEmail(String email, Context context) {
//        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(KEY_EMAIL , email);
//        editor.apply();
//        return true;
//    }
//
//    public static String getEmail(Context context){
//        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
//        String email = preferences.getString(KEY_EMAIL, null);
//        return email;
//    }
//
//    public static boolean savePassword(String password, Context context){
//        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(KEY_PASSWORD, password);
//        editor.apply();
//        return true;
//    }
//
//    public static String getPassword(Context context){
//        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
//        String password = preferences.getString(KEY_PASSWORD, null);
//        return password;
//    }

}
