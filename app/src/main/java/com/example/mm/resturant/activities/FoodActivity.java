package com.example.mm.resturant.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mm.resturant.R;
import com.example.mm.resturant.Util.InputValidation;
import com.example.mm.resturant.models.SQLiteHelper.DataBaseHelper;
import com.example.mm.resturant.models.sharedpreferenceshelber.SharedPreferencesStorage;

public class FoodActivity extends AppCompatActivity {

    private SharedPreferencesStorage mSharedPreferencesStorage;
    private ActionBar mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mBar = getSupportActionBar();
        mBar.setTitle("");
        initObjects();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int getId = item.getItemId();
        switch (getId){
            case R.id.logout:
                userLogout();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void userLogout() {
        mSharedPreferencesStorage.putEmail(null);
        mSharedPreferencesStorage.putPassword(null);

        Intent toLogin = new Intent(this, LoginActivity.class);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(toLogin);
        finish();
    }

    private void initObjects(){
        mSharedPreferencesStorage = new SharedPreferencesStorage(FoodActivity.this);
    }

}
