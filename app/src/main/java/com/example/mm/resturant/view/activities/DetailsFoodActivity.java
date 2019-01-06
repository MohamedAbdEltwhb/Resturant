package com.example.mm.resturant.view.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mm.resturant.R;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Bold;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Regular;
import com.example.mm.resturant.models.SQLiteHelper.UserTable.DataBaseHelper;
import com.example.mm.resturant.models.sharedpreferenceshelber.OrderStorage;

import static com.example.mm.resturant.view.adaptor.FoodAdaptor.MINUTES_NUMBER;
import static com.example.mm.resturant.view.adaptor.FoodAdaptor.PLATE_IMAGE_VIEW;
import static com.example.mm.resturant.view.adaptor.FoodAdaptor.PRISE;
import static com.example.mm.resturant.view.adaptor.FoodAdaptor.TEXT_FOOD_NAME;

public class DetailsFoodActivity extends AppCompatActivity implements View.OnClickListener{

    private MyTextView_Roboto_Regular textFoodName, minutesNumber, priseNumber, foodDescription;
    private ImageView plateImageView;
    private Button mDeCrement;
    private MyTextView_Roboto_Bold mQuantityTextView;
    private Button mInCrement;

    private int mQuantity = 0;

    private Toolbar mToolbar;
    private TextView mToolbarText;
    private TextView mAddToOrderButton;
    private ImageView mBack;

    private OrderStorage mOrderStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_food);

        mOrderStorage = new OrderStorage(this);

        initViews();
        initListeners();

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbarText.setText("Recipe");
        mBack.setVisibility(View.VISIBLE);

        Intent intent = getIntent();

        textFoodName.setText(intent.getStringExtra(TEXT_FOOD_NAME));
        minutesNumber.setText(intent.getStringExtra(MINUTES_NUMBER));
        priseNumber.setText(intent.getStringExtra(PRISE));
        Glide.with(this).load(intent.getStringExtra(PLATE_IMAGE_VIEW)).into(plateImageView);

        foodDescription.setText(getString(R.string.food_description));
    }

    private void initViews() {
        textFoodName = findViewById(R.id.textFoodName);
        minutesNumber = findViewById(R.id.detailsMinutesNumber);
        plateImageView = findViewById(R.id.plateImageView);
        priseNumber = findViewById(R.id.priseNumber);
        foodDescription = findViewById(R.id.foodDescription);

        mToolbar = findViewById(R.id.include2);
        mToolbarText = mToolbar.findViewById(R.id.textToolbar);
        mBack = mToolbar.findViewById(R.id.back);

        mDeCrement = findViewById(R.id.deCrement);
        mQuantityTextView = findViewById(R.id.quantity_text_view);
        mInCrement = findViewById(R.id.inCrement);
        mAddToOrderButton = findViewById(R.id.add_to_order_button);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.back:
                startActivity(new Intent(DetailsFoodActivity.this, FoodActivity.class));
                break;

            case R.id.deCrement:
                if (mQuantity == 0){
                    showToast("You Cannot have Less than 1 Coffee");
                    return;
                }
                mQuantity --;
                mQuantityTextView.setText(String.valueOf(mQuantity));
                break;

            case R.id.inCrement:
                if (mQuantity == 70){
                    showToast("You Cannot have more than 70 Coffees");
                    return;
                }
                mQuantity ++;
                mQuantityTextView.setText(String.valueOf(mQuantity));
                break;

            case R.id.add_to_order_button:

                break;
        }
    }

    private void initListeners(){
        mDeCrement.setOnClickListener(this);
        mInCrement.setOnClickListener(this);
        mAddToOrderButton.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    private void showToast (String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
