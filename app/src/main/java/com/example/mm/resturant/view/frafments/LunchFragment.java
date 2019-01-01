package com.example.mm.resturant.view.frafments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mm.resturant.R;
import com.example.mm.resturant.view.adaptor.FoodAdaptor;
import com.example.mm.resturant.view.adaptor.FoodFakeData;
import com.example.mm.resturant.view.adaptor.OnFoodAdaptorClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class LunchFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FoodAdaptor mRecipeAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    public LunchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lunch, container, false);

        mRecyclerView = view.findViewById(R.id.lunchRecyclerView);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecipeAdapter = new FoodAdaptor(getContext(), FoodFakeData.getmRecipeFakeData());

        mRecyclerView.setAdapter(mRecipeAdapter);


        return view;
    }

}
