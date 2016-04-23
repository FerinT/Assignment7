package com.example.ferin.airtimeatm.repository.networkCodes.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;
import com.example.ferin.airtimeatm.repository.networkCodes.NetworkCodesRepository;
import com.example.ferin.airtimeatm.conf.database.DBConstants;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ferin on 2016-04-23.
 */
public class NetworkCodesRepositoryImpl extends SQLiteOpenHelper implements NetworkCodesRepository{

    public static final String TABLE_NAME = "networkCodes";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NETWORKNAME = "networkName";
    public static final String COLUMN_BALANCE = "balance";
    public static final String COLUMN_PCM = "pcm";
    public static final String COLUMN_RECHARGE = "recharge";
    public static final String COLUMN_MENU = "menu";
    public static final String COLUMN_TRANSFER = "transfer";

    // Database creation sql statement

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NETWORKNAME + " TEXT  NOT NULL , "
            + COLUMN_BALANCE + " TEXT  NOT NULL , "
            + COLUMN_PCM + " TEXT  NOT NULL , "
            + COLUMN_RECHARGE + " TEXT  NOT NULL , "
            + COLUMN_MENU + " TEXT  NOT NULL , "
            + COLUMN_TRANSFER + " TEXT NOT NULL );";


    public NetworkCodesRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }


    @Override // find the codes by searching networkname
    public NetworkCodes findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
               TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NETWORKNAME,
                        COLUMN_BALANCE,
                        COLUMN_PCM,
                        COLUMN_RECHARGE,
                        COLUMN_MENU,
                        COLUMN_TRANSFER},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            final NetworkCodes networkCodes = new NetworkCodes.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .networkName(cursor.getString(cursor.getColumnIndex(COLUMN_NETWORKNAME)))
                    .balanceEnquiry(cursor.getString(cursor.getColumnIndex(COLUMN_BALANCE)))
                    .pcm(cursor.getString(cursor.getColumnIndex(COLUMN_PCM)))
                    .recharge(cursor.getString(cursor.getColumnIndex(COLUMN_RECHARGE)))
                    .menu(cursor.getString(cursor.getColumnIndex(COLUMN_MENU)))
                    .transfer((cursor.getString(cursor.getColumnIndex(COLUMN_TRANSFER))))
                    .build();
            return networkCodes;
        }
        else{
            return null;
        }
    }

    @Override
    public NetworkCodes save(NetworkCodes entity) {
        open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NETWORKNAME, entity.getNetworkName());
        contentValues.put(COLUMN_BALANCE, entity.getBalanceEnquiry());
        contentValues.put(COLUMN_PCM, entity.getPcm());
        contentValues.put(COLUMN_RECHARGE, entity.getRecharge());
        contentValues.put(COLUMN_MENU, entity.getMenu());
        contentValues.put(COLUMN_TRANSFER,entity.getTransfer());

        long id = db.insertOrThrow(TABLE_NAME, null,contentValues);
        NetworkCodes networkCodes = new NetworkCodes.Builder()
                .copy(entity)
                .id(id)
                .build();

        return networkCodes;
    }

    @Override
    public NetworkCodes update(NetworkCodes entity) {
        open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_ID, entity.getId());
        contentValues.put(COLUMN_NETWORKNAME, entity.getNetworkName());
        contentValues.put(COLUMN_BALANCE, entity.getBalanceEnquiry());
        contentValues.put(COLUMN_PCM, entity.getPcm());
        contentValues.put(COLUMN_RECHARGE, entity.getRecharge());
        contentValues.put(COLUMN_MENU, entity.getMenu());
        contentValues.put(COLUMN_TRANSFER,entity.getTransfer());

        db.update(
                TABLE_NAME,
                contentValues,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public NetworkCodes delete(NetworkCodes entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<NetworkCodes> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<NetworkCodes> networkCodes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final NetworkCodes networkCodes1 = new NetworkCodes.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .balanceEnquiry(cursor.getString(cursor.getColumnIndex(COLUMN_BALANCE)))
                        .pcm(cursor.getString(cursor.getColumnIndex(COLUMN_PCM)))
                        .recharge(cursor.getString(cursor.getColumnIndex(COLUMN_RECHARGE)))
                        .menu(cursor.getString(cursor.getColumnIndex(COLUMN_MENU)))
                        .transfer((cursor.getString(cursor.getColumnIndex(COLUMN_TRANSFER))))
                        .build();
                networkCodes.add(networkCodes1);
            } while (cursor.moveToNext());
        }
        return networkCodes;
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
        db.execSQL(DATABASE_CREATE);
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
