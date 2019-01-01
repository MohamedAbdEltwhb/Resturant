package com.example.mm.resturant.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mm.resturant.R;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Regular;

import static com.example.mm.resturant.view.adaptor.FoodAdaptor.MINUTES_NUMBER;
import static com.example.mm.resturant.view.adaptor.FoodAdaptor.PLATE_IMAGE_VIEW;
import static com.example.mm.resturant.view.adaptor.FoodAdaptor.TEXT_FOOD_NAME;

public class DetailsFoodActivity extends AppCompatActivity {

    private MyTextView_Roboto_Regular textFoodName, minutesNumber;
    private ImageView plateImageView;

    private Toolbar mToolbar;
    private TextView mToolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_food);
        initViews();

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbarText.setText("Recipe");

        Intent intent = getIntent();

        textFoodName.setText(String.valueOf(intent.getStringExtra(TEXT_FOOD_NAME)));
        minutesNumber.setText(String.valueOf(intent.getStringExtra(MINUTES_NUMBER)));

        Glide.with(this).load(intent.getStringExtra(PLATE_IMAGE_VIEW)).into(plateImageView);
    }

    private void initViews() {
        textFoodName = findViewById(R.id.textFoodName);
        minutesNumber = findViewById(R.id.minutesNumber);
        plateImageView = findViewById(R.id.plateImageView);

        mToolbar = findViewById(R.id.include2);
        mToolbarText = mToolbar.findViewById(R.id.textToolbar);
    }

}
