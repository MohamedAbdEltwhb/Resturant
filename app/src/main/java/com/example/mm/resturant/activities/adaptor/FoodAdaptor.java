package com.example.mm.resturant.activities.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mm.resturant.R;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Bold;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Regular;
import com.example.mm.resturant.models.data.RecipeInfo;

import java.util.List;

public class FoodAdaptor extends RecyclerView.Adapter<FoodAdaptor.ViewHolder>{

    private Context mContext;
    private List<RecipeInfo> mRecipeInfo;

    public FoodAdaptor(Context mContext, List<RecipeInfo> mRecipeInfo) {
        this.mContext = mContext;
        this.mRecipeInfo = mRecipeInfo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecipeInfo recipeInfo = mRecipeInfo.get(position);

        holder.textFoodName.setText(String.valueOf(recipeInfo.getFoodName()));
        holder.minutesNumber.setText(String.valueOf(recipeInfo.getMinutesNumber()));
        holder.nutritionsNumber.setText(String.valueOf(recipeInfo.getNutritionsNumber()));
        holder.likesNumber.setText(String.valueOf(recipeInfo.getLikesNumber()));
        holder.sharesNumber.setText(String.valueOf(recipeInfo.getSharesNumber()));

        holder.plateImageView.setImageResource(recipeInfo.getPlateImage());
        holder.imageLikes.setImageResource(recipeInfo.getImageLikes());


//        Glide.with(mContext).load(recipeInfo.getPlateImage()).into(holder.plateImageView);
//        Glide.with(mContext).load(recipeInfo.getImageLikes()).into(holder.imageLikes);

    }

    @Override
    public int getItemCount() {
        return mRecipeInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView plateImageView, imageLikes;
        private MyTextView_Roboto_Bold textFoodName;
        private MyTextView_Roboto_Regular minutesNumber, nutritionsNumber, likesNumber, sharesNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            plateImageView = itemView.findViewById(R.id.plateImageView);
            imageLikes = itemView.findViewById(R.id.imageLikes);
            textFoodName = itemView.findViewById(R.id.textFoodName);
            minutesNumber = itemView.findViewById(R.id.minutesNumber);
            nutritionsNumber = itemView.findViewById(R.id.nutritionsNumber);
            likesNumber = itemView.findViewById(R.id.likesNumber);
            sharesNumber = itemView.findViewById(R.id.sharesNumber);
        }
    }
}
