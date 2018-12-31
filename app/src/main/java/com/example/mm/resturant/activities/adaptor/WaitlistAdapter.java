package com.example.mm.resturant.activities.adaptor;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mm.resturant.R;
import com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable.WaitlistContract.WaitlistEntry;

public class WaitlistAdapter extends RecyclerView.Adapter<WaitlistAdapter.Guestviewholder>{

    Context mContext;
    Cursor mCursor;

    public WaitlistAdapter(Context mContext, Cursor mCursor) {
        this.mContext = mContext;
        this.mCursor = mCursor;
    }

    @NonNull
    @Override
    public Guestviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.waitlist_item, parent, false);
        return new Guestviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Guestviewholder holder, int position) {
        if (!mCursor.moveToPosition(position)){
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex(WaitlistEntry.COLUMN_GUEST_NAME));
        String size = mCursor.getString(mCursor.getColumnIndex(WaitlistEntry.COLUMN_PARTY_SIZE));
        Long id = mCursor.getLong(mCursor.getColumnIndex(WaitlistEntry._ID));

        holder.name.setText(name);
        holder.size.setText(size);
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        // Always close the previous mCursor first
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    public class Guestviewholder extends RecyclerView.ViewHolder{

        TextView name,size;

        public Guestviewholder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_result);
            size = (TextView) itemView.findViewById(R.id.size_result);
        }
    }
}
