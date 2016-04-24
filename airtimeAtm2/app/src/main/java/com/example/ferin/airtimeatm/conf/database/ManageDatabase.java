package com.example.ferin.airtimeatm.conf.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ferin on 2016-04-24.
 */

/* Ensures database is created with all tables */

public class ManageDatabase extends SQLiteOpenHelper {

    public static final String TABLE_NAME1 = "networkCodes";

    public static final String COLUMN_ID1 = "id";
    public static final String COLUMN_NETWORKNAME1 = "networkName";
    public static final String COLUMN_BALANCE = "balance";
    public static final String COLUMN_PCM = "pcm";
    public static final String COLUMN_RECHARGE = "recharge";
    public static final String COLUMN_MENU = "menu";
    public static final String COLUMN_TRANSFER = "transfer";

    // Database creation sql statement

    private static final String DATABASE_CREATE1 = " CREATE TABLE "
            + TABLE_NAME1 + "("
            + COLUMN_ID1 + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NETWORKNAME1 + " TEXT  NOT NULL , "
            + COLUMN_BALANCE + " TEXT  NOT NULL , "
            + COLUMN_PCM + " TEXT  NOT NULL , "
            + COLUMN_RECHARGE + " TEXT  NOT NULL , "
            + COLUMN_MENU + " TEXT  NOT NULL , "
            + COLUMN_TRANSFER + " TEXT NOT NULL );";



    public static final String TABLE_NAME = "appUser";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CELLPHONENUMBER = "cellphoneNumber";
    public static final String COLUMN_ANDROIDID = "androidID";
    public static final String COLUMN_NETWORKNAME = "networkName";
    //public static final String COLUMN_NETWORKCODE = "networkCode";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CELLPHONENUMBER + " TEXT  NOT NULL , "
            + COLUMN_NETWORKNAME + " TEXT  NOT NULL , "
            //+ COLUMN_NETWORKCODE + " TEXT  NOT NULL , "
            + COLUMN_ANDROIDID + " TEXT UNIQUE NOT NULL );";


    public ManageDatabase(Context context)
    {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public ManageDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabase db) {
        super(context, name, factory, version);
        this.db = db;
    }

    public ManageDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler, SQLiteDatabase db) {
        super(context, name, factory, version, errorHandler);
        this.db = db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE1);
    }

    public void deleteTable(String tablename){
        db.execSQL("DROP TABLE IF EXISTS "+tablename+";");
    }

    public boolean deleteDatabase(Context context) {
        return context.deleteDatabase(DBConstants.DATABASE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
