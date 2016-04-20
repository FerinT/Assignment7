package com.example.ferin.airtimeatm.repository.appUser.impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ferin.airtimeatm.conf.database.DBConstants;
import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.repository.appUser.AppUserRepository;

import java.util.Set;

public class AppUserRepositoryImpl extends SQLiteOpenHelper implements AppUserRepository{

    public static final String TABLE_NAME = "appUser";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CELLPHONENUMBER = "cellphoneNumber";
    public static final String COLUMN_ANDROIDID = "androidID";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CELLPHONENUMBER + " TEXT  NOT NULL , "
            + COLUMN_ANDROIDID + " TEXT UNIQUE NOT NULL );";


    public AppUserRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
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
                        COLUMN_ANDROIDID},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            final AppUser appUser = new AppUser.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .cellphoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CELLPHONENUMBER)))
                    .androidID(cursor.getString(cursor.getColumnIndex(COLUMN_ANDROIDID)))
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
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CELLPHONENUMBER, entity.getCellphoneNumber());
        values.put(COLUMN_ANDROIDID, entity.getAndroidID());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        AppUser appUser = new AppUser.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();

        return appUser;

    }

    @Override
    public AppUser update(AppUser entity) {
        return null;
    }

    @Override
    public AppUser delete(AppUser entity) {
        return null;
    }

    @Override
    public Set<AppUser> findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
