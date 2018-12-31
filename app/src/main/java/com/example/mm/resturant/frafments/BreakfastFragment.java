package com.example.mm.resturant.frafments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mm.resturant.R;
import com.example.mm.resturant.activities.adaptor.FoodAdaptor;
import com.example.mm.resturant.activities.adaptor.FoodFakeData;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreakfastFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FoodAdaptor mRecipeAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    public BreakfastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_breakfast, container, false);


        mRecyclerView = view.findViewById(R.id.breakfastRecyclerView);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecipeAdapter = new FoodAdaptor(getContext(), FoodFakeData.getmRecipeFakeData());

        mRecyclerView.setAdapter(mRecipeAdapter);


        return view;

    }

}
