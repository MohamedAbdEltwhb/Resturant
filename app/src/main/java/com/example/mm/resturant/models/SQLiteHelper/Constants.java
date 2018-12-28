package com.example.mm.resturant.models.SQLiteHelper;

public abstract class Constants {



    /**
     * @DataBaseHelper Class Constants
     *
     * */
    public static final String DATABASE_NAME = "regester.db";
    public static final String TABLE_NAME = "registeration";

    public static final int VERSION = 6;

    public static final String ID_1 = "ID";
    public static final String FIRSTNAME_2 = "FirstName";
    public static final String LASTNAME_3 = "LastName";
    public static final String PASSWORD_4 = "Password";
    public static final String RE_PASSWORD_5 = "RePassword";
    public static final String EMAIL_6 = "Email";
    public static final String PHONE_7 = "Phone";

    public static String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FIRSTNAME_2 + " TEXT," + LASTNAME_3 + " TEXT,"
            + PASSWORD_4 + " TEXT," + RE_PASSWORD_5 + " TEXT,"
            + EMAIL_6 + " TEXT," + PHONE_7 + " TEXT" + ")";

    public static String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
