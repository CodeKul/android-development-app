package com.codekul.sqlitedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codekul.sqlitedemo.MainActivity;

/**
 * Created by root on 12/4/16.
 */
public class DbHelper  extends SQLiteOpenHelper{

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(MainActivity.TAG, "on Create Sqlite helper");
        db.execSQL("CREATE TABLE "+ Database.TAB_CAR +"( "+Database.COL_CAR_NAME+" text, "+Database.COL_CAR_OWNER+" text, "+Database.COL_CAR_VER+" number " +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(MainActivity.TAG,"on upgrade Sqlite helper");
    }

    public static final class Database {

        public static final String DB_NAME = "codekul_db";
        public static final Integer DB_VERSION = 1;
        public static final String TAB_CAR = "tab_car";

        public static final String COL_CAR_NAME = "car_name";
        public static final String COL_CAR_OWNER = "car_owner";
        public static final String COL_CAR_VER = "car_ver";
    }
}
