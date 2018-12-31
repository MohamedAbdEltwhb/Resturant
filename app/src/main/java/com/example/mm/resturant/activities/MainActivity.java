package com.example.mm.resturant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mm.resturant.R;
import com.example.mm.resturant.models.sharedpreferenceshelber.SharedPreferencesStorage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView mRecipeCardView, mWaitlistesCardView;
    private TextView mToolbarText;
    private SharedPreferencesStorage mSharedPreferencesStorage;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initObjects();
        initListeners();

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbarText.setText("Resturant");

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

    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId){
            case R.id.cardView_recipe:
                startActivity(new Intent(this, FoodActivity.class));
                break;
            case R.id.cardView_lunch:
                startActivity(new Intent(this, WaitlistesTableActivity.class));
                break;
        }
    }

    private void initObjects(){
        mSharedPreferencesStorage = new SharedPreferencesStorage(MainActivity.this);
    }

    private void initViews() {
        mToolbar = findViewById(R.id.food_toolbar);
        mToolbarText = mToolbar.findViewById(R.id.textToolbar);
        mRecipeCardView = findViewById(R.id.cardView_recipe);
        mWaitlistesCardView = findViewById(R.id.cardView_lunch);
    }

    private void initListeners(){
        mRecipeCardView.setOnClickListener(this);
        mWaitlistesCardView.setOnClickListener(this);
    }

}
