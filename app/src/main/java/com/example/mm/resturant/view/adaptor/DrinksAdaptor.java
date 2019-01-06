package com.example.mm.resturant.view.adaptor;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mm.resturant.R;
import com.example.mm.resturant.Util.DrinksDialog;
import com.example.mm.resturant.models.data.DrinksInfo;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DrinksAdaptor extends RecyclerView.Adapter<DrinksAdaptor.ViewHolder> {

    private Context mContext;
    private List<DrinksInfo> mDrinksList;

    public DrinksAdaptor(Context mContext, List<DrinksInfo> mDrinksList) {
        this.mContext = mContext;
        this.mDrinksList = mDrinksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.drinks_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DrinksInfo drinksInfo = mDrinksList.get(position);

        holder.drinksName.setText(drinksInfo.getmDrinksName());
        Glide.with(mContext).load(drinksInfo.getmDrinksImage()).into(holder.drinksImageView);
    }

    @Override
    public int getItemCount() {
        return mDrinksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CircleImageView drinksImageView ;
        private TextView drinksName;

        public ViewHolder(View itemView) {
            super(itemView);
            drinksImageView = itemView.findViewById(R.id.circleImageView);
            drinksName = itemView.findViewById(R.id.drinks_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            DrinksInfo info = mDrinksList.get(getAdapterPosition());

            DrinksDialog drinksDialog = new DrinksDialog(mContext, info.getmDrinksImage(), info.getmDrinksName());
            drinksDialog.showDrinksDialog();
        }
    }

}
