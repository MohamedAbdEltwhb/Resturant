package com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable.WaitlistContract.WaitlistEntry;

import static com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable.WaitlistContract.WaitlistEntry.SQL_CREATE_WAITLIST_TABLE;
import static com.example.mm.resturant.models.SQLiteHelper.WaitlistesTable.WaitlistContract.WaitlistEntry.SQL_DROP_WAITLIST_TABLE;

public class WaitlistDBhelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "waitlist.db";

    private static final int DATABASE_VERSION = 1;

    private static SQLiteDatabase sqLiteDatabase;

    public WaitlistDBhelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_WAITLIST_TABLE);
        onCreate(db);

    }

    public long addNewGuest(String name, String partySize) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME, name);
        cv.put(WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE, partySize);
        return sqLiteDatabase.insert(WaitlistContract.WaitlistEntry.TABLE_NAME, null, cv);
    }

    public Cursor getAllGuests() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.query(
                WaitlistContract.WaitlistEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP
        );
    }

    public boolean removeGuest(long id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(WaitlistContract.WaitlistEntry.TABLE_NAME,
                WaitlistContract.WaitlistEntry._ID + "=" + id, null) > 0;
    }
}
