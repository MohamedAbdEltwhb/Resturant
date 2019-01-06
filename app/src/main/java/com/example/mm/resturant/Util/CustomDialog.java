package com.example.mm.resturant.Util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mm.resturant.R;
import com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable.WaitlistDBhelper;
import com.example.mm.resturant.view.adaptor.WaitlistAdapter;

public class CustomDialog {

    private ImageView waitlist;
    private WaitlistAdapter guestAdapter;
    private WaitlistDBhelper waitlistDBhelper;

    private Context context;


    public CustomDialog(Context context, ImageView waitlist,
                        WaitlistAdapter guestAdapter) {

        this.context = context;
        this.waitlist = waitlist;
        this.guestAdapter = guestAdapter;
    }

    public void showCustomDialog() {

        waitlistDBhelper = new WaitlistDBhelper(context.getApplicationContext());

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.newguest_dialoge);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final Button add_guest =  dialog.findViewById(R.id.add_guest_btn);
        final Button back =  dialog.findViewById(R.id.back_btn);

        final EditText guest_name =  dialog.findViewById(R.id.guest_name);
        final EditText guest_number =  dialog.findViewById(R.id.guest_number);


        add_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = guest_name.getText().toString();
                String number = guest_number.getText().toString();

                if (name.length() == 0 || number.length() == 0)
                {

                }
                else
                {
                    waitlistDBhelper.addNewGuest(name,number);
                    guestAdapter.swapCursor(waitlistDBhelper.getAllGuests());

                    waitlist.setVisibility(View.GONE);

                    dialog.dismiss();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
}
