package com.example.mm.resturant.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mm.resturant.R;
import com.example.mm.resturant.view.adaptor.DrinksAdaptor;
import com.example.mm.resturant.view.adaptor.FoodFakeData;

public class DrinksActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DrinksAdaptor mDrinksAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        mRecyclerView = findViewById(R.id.recyclerViewDrinks);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mDrinksAdaptor = new DrinksAdaptor(this, FoodFakeData.getmDrinksData());

        mRecyclerView.setAdapter(mDrinksAdaptor);
    }
}
