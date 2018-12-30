package com.example.mm.resturant.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mm.resturant.R;
import com.example.mm.resturant.activities.adaptor.RecipeAdaptor;
import com.example.mm.resturant.activities.adaptor.RecipeFakeData;

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeAdaptor mRecipeAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        mRecyclerView = findViewById(R.id.recyclerViewRecipe);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecipeAdapter = new RecipeAdaptor(this, RecipeFakeData.getmRecipeFakeData());

        mRecyclerView.setAdapter(mRecipeAdapter);
    }
}
