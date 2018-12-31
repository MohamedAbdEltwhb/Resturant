package com.example.mm.resturant.view.activities;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mm.resturant.R;
import com.example.mm.resturant.Util.CustomDialog;
import com.example.mm.resturant.view.adaptor.WaitlistAdapter;
import com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable.WaitlistDBhelper;


public class WaitlistesTableActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton add_user;
    private ImageView waitlist;
    private RecyclerView recyclerView;
    private WaitlistDBhelper waitlistDBhelper;
    private WaitlistAdapter guestAdapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waitlistes_table);
        initViews();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        waitlistDBhelper = new WaitlistDBhelper(getApplicationContext());

        cursor =  waitlistDBhelper.getAllGuests();
        guestAdapter = new WaitlistAdapter(getApplicationContext(), cursor);
        recyclerView.setAdapter(guestAdapter);

        if (cursor.getCount() != 0) {
            waitlist.setVisibility(View.GONE);
        } else {
            waitlist.setVisibility(View.VISIBLE);
        }

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                long id = (long) viewHolder.itemView.getTag();
                //remove from DB
                waitlistDBhelper.removeGuest(id);

                //update the list
                guestAdapter.swapCursor(waitlistDBhelper.getAllGuests());

                if (waitlistDBhelper.getAllGuests().getCount() == 0) {
                    waitlist.setVisibility(View.VISIBLE);
                }
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.add_new_guest:
                CustomDialog customDialog = new CustomDialog(WaitlistesTableActivity.this, waitlist, guestAdapter);
                customDialog.showCustomDialog();
                break;
        }
    }

    private void initViews() {
        add_user =  findViewById(R.id.add_new_guest);
        add_user.setOnClickListener(this);
        recyclerView =  findViewById(R.id.recycler_view);
        waitlist =  findViewById(R.id.waitlist_image);
    }


}
