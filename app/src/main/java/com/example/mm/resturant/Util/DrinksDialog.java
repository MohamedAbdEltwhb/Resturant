package com.example.mm.resturant.Util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mm.resturant.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class DrinksDialog {

    private Context mContext;
    private int mImageResourc;
    private String mTextDrinksName;

    private int mDrinkQuantity = 0;

    public DrinksDialog(Context mContext, int mImageResourc, String mTextDrinksName) {
        this.mContext = mContext;
        this.mImageResourc = mImageResourc;
        this.mTextDrinksName = mTextDrinksName;
    }

    public void showDrinksDialog (){

        final Dialog mDialog = new Dialog(mContext);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        mDialog.setContentView(R.layout.drinks_custom_dialod);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(mDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final CircleImageView imageView = mDialog.findViewById(R.id.circleImageView2);
        final TextView drinksNameTextView = mDialog.findViewById(R.id.drinks_name_text_View);
        final Button inCrementButton = mDialog.findViewById(R.id.inCrement_button);
        final TextView quantityDrinksTextView = mDialog.findViewById(R.id.quantity_drinks_text_view);
        final Button deCrementButton = mDialog.findViewById(R.id.deCrement_button);
        final Button dialogBackButton = mDialog.findViewById(R.id.dialog_back_btn);
        final Button addToOrder = mDialog.findViewById(R.id.add_to_order);

        Glide.with(mContext).load(mImageResourc).into(imageView);
        drinksNameTextView.setText(mTextDrinksName);

        inCrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrinkQuantity == 70){
                    Toast t = Toast.makeText(mContext, "You Cannot have more than 70", Toast.LENGTH_SHORT);
                    View view = t.getView();
                    view.setBackgroundColor(Color.RED);

                    t.show();
                    //showToast("You Cannot have more than 70 ");
                    return;
                }
                mDrinkQuantity ++;
                quantityDrinksTextView.setText(String.valueOf(mDrinkQuantity));
            }
        });

        deCrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrinkQuantity == 0){
                    Toast t = Toast.makeText(mContext, "You Cannot have Less than 1", Toast.LENGTH_SHORT);
                    View view = t.getView();
                    view.setBackgroundColor(Color.RED);
                    t.show();
                    //showToast("You Cannot have Less than 1");
                    return;
                }
                mDrinkQuantity --;
                quantityDrinksTextView.setText(String.valueOf(mDrinkQuantity));
            }
        });

        dialogBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        mDialog.show();
        mDialog.getWindow().setAttributes(lp);
    }
}
