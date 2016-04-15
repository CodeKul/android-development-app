package com.codekul.sqlitedemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codekul.sqlitedemo.db.DbHelper;

import java.util.List;

/**
 * Created by root on 15/4/16.
 */
public class DbProvider extends ContentProvider{

    public static final Uri CONTENT_URI = Uri.parse("content://com.codekul.content.provider");
    private DbHelper helper;
    @Override
    public boolean onCreate() {

        helper = new DbHelper(getContext(),DbHelper.Database.DB_NAME,null,1);

        return true;
    }
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        String carName = uri.getPathSegments().get(0);
        String carVer = uri.getPathSegments().get(1);
        String sel = "car_name = ? and car_ver = ?";
        String []selArgs = {carName,carVer};

        SQLiteDatabase sqDb = helper.getReadableDatabase();
        Cursor cusror = sqDb.query(DbHelper.Database.TAB_CAR,null,selection,selectionArgs,null,null,sortOrder);

        return cusror;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return CONTENT_URI;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
