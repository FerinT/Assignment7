package com.example.ferin.airtimeatm.repository.appUser.impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ferin.airtimeatm.conf.database.ManageDatabase;
import com.example.ferin.airtimeatm.conf.util.App;
import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.repository.appUser.AppUserRepository;
import com.example.ferin.airtimeatm.conf.database.DBConstants;

import java.util.HashSet;
import java.util.Set;

public class AppUserRepositoryImpl extends SQLiteOpenHelper implements AppUserRepository {

    public static final String TABLE_NAME = "appUser";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CELLPHONENUMBER = "cellphoneNumber";
    public static final String COLUMN_ANDROIDID = "androidID";
    public static final String COLUMN_NETWORKNAME = "networkName";
    //public static final String COLUMN_NETWORKCODE = "networkCode";

    public AppUserRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }

    public AppUserRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AppUserRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public AppUser findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CELLPHONENUMBER,
                        COLUMN_NETWORKNAME,
                        //COLUMN_NETWORKCODE,
                        COLUMN_ANDROIDID},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            final CellphoneNetwork cellphoneNetwork = new CellphoneNetwork.Builder()
                    .networkName(cursor.getString(cursor.getColumnIndex(COLUMN_NETWORKNAME)))
                    .build(); //value object

            //final NetworkCodes networkCodes = new NetworkCodeFactoryImpl().getNetworkCodes(cellphoneNetwork.getNetworkName());

            final AppUser appUser = new AppUser.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .cellphoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CELLPHONENUMBER)))
                    .androidID(cursor.getString(cursor.getColumnIndex(COLUMN_ANDROIDID)))
                    .cellphoneNetwork(cellphoneNetwork)
                    .build();
            return appUser;
                }
        else{
            return null;
        }
    }

    @Override
    public AppUser save(AppUser entity) {

        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_CELLPHONENUMBER, entity.getCellphoneNumber());
        values.put(COLUMN_ANDROIDID, entity.getAndroidID());
        values.put(COLUMN_NETWORKNAME, entity.getCellphoneNetwork().getNetworkName());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        AppUser appUser = new AppUser.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();

        return appUser;

    }

    @Override
    public AppUser update(AppUser entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ANDROIDID, entity.getAndroidID());
        values.put(COLUMN_CELLPHONENUMBER, entity.getCellphoneNumber());
        values.put(COLUMN_NETWORKNAME, entity.getCellphoneNetwork().getNetworkName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public AppUser delete(AppUser entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<AppUser> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<AppUser> appUserSet = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final CellphoneNetwork cellphoneNetwork = new CellphoneNetwork.Builder()
                        .networkName(cursor.getString(cursor.getColumnIndex(COLUMN_NETWORKNAME)))
                        .build(); //value object
                final AppUser appUser = new AppUser.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .androidID(cursor.getString(cursor.getColumnIndex(COLUMN_ANDROIDID)))
                        .cellphoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CELLPHONENUMBER)))
                        .cellphoneNetwork(cellphoneNetwork)
                        .build();
                appUserSet.add(appUser);
            } while (cursor.moveToNext());
        }
        return appUserSet;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        //close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL(DATABASE_CREATE);

        ManageDatabase manageDatabase = new ManageDatabase(App.getInstance());
        manageDatabase.deleteTable("appUser");
        manageDatabase.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
