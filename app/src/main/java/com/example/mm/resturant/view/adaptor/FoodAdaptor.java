package com.example.mm.resturant.view.adaptor;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.ArgbEvaluator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mm.resturant.R;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Bold;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Regular;
import com.example.mm.resturant.models.data.FoodInfo;
import com.example.mm.resturant.view.activities.DetailsFoodActivity;
import com.example.mm.resturant.view.activities.WaitlistesTableActivity;

import java.util.List;

public class FoodAdaptor extends RecyclerView.Adapter<FoodAdaptor.ViewHolder>{

    public static final String TEXT_FOOD_NAME = "textFoodName";
    public static final String MINUTES_NUMBER = "minutesNumber";
    public static final String PLATE_IMAGE_VIEW = "plateImageView";

    private Context mContext;
    private List<FoodInfo> mRecipeInfo;

    private OnFoodAdaptorClickListener mOnFoodAdaptorClickListener;

    public FoodAdaptor(Context mContext, List<FoodInfo> mRecipeInfo) {
        this.mContext = mContext;
        this.mRecipeInfo = mRecipeInfo;
    }

    public void setOnItemClickListener (OnFoodAdaptorClickListener listener){
        mOnFoodAdaptorClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final FoodInfo recipeInfo = mRecipeInfo.get(position);

        holder.textFoodName.setText(String.valueOf(recipeInfo.getFoodName()));
        holder.minutesNumber.setText(String.valueOf(recipeInfo.getMinutesNumber()));
        holder.nutritionsNumber.setText(String.valueOf(recipeInfo.getNutritionsNumber()));
        holder.likesNumber.setText(String.valueOf(recipeInfo.getLikesNumber()));
        holder.sharesNumber.setText(String.valueOf(recipeInfo.getSharesNumber()));

        //holder.plateImageView.setImageResource(recipeInfo.getPlateImage());
        Glide.with(mContext).load(recipeInfo.getPlateImage()).into(holder.plateImageView);

        holder.imageLikes.setImageResource(R.drawable.ic_favorite_grey);
        holder.imageLikes.setOnClickListener(new View.OnClickListener() {
            ValueAnimator buttonColorAnim = null; // to hold the button animator
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                if(buttonColorAnim != null){
                    buttonColorAnim.reverse();
                    buttonColorAnim = null;
                }
                else {
                    final ImageView button = (ImageView) v;
                    buttonColorAnim = ValueAnimator.ofObject(new ArgbEvaluator(), R.drawable.ic_favorite_grey, R.drawable.ic_favorite_red);
                    buttonColorAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animator) {
                            button.setImageResource((Integer) animator.getAnimatedValue());
                        }
                    });
                    buttonColorAnim.start();
                }
            }
        });

//        holder.mCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, DetailsFoodActivity.class);
//
//                intent.putExtra(TEXT_FOOD_NAME, recipeInfo.getFoodName());
//                intent.putExtra(MINUTES_NUMBER, recipeInfo.getMinutesNumber());
//                intent.putExtra(PLATE_IMAGE_VIEW, recipeInfo.getPlateImage());
//
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mRecipeInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView mCardView;
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

            mCardView = itemView.findViewById(R.id.cardView5);
            mCardView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            FoodInfo mFoodInfo = mRecipeInfo.get(getAdapterPosition());

            Intent intent = new Intent(mContext, DetailsFoodActivity.class);

            intent.putExtra(TEXT_FOOD_NAME, mFoodInfo.getFoodName());
            intent.putExtra(MINUTES_NUMBER, mFoodInfo.getMinutesNumber());
            intent.putExtra(PLATE_IMAGE_VIEW, mFoodInfo.getPlateImage());

            mContext.startActivity(intent);

        }
    }
}
