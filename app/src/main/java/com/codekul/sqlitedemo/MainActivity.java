package com.codekul.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.codekul.sqlitedemo.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "@codekul_sqlite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Click click = new Click();
        final DbHelper helper = new DbHelper(this, DbHelper.Database.DB_NAME,null, DbHelper.Database.DB_VERSION);

        findViewById(R.id.btnInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insert(helper);
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                update(helper);
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delete(helper);
            }
        });

        findViewById(R.id.btnQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                query(helper);;
            }
        });
    }

    private void insert(SQLiteOpenHelper helper){

        SQLiteDatabase sqDb = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbHelper.Database.COL_CAR_NAME,"Bmw");
        values.put(DbHelper.Database.COL_CAR_OWNER,"Android");
        values.put(DbHelper.Database.COL_CAR_VER,1);

        sqDb.insert(DbHelper.Database.TAB_CAR,null,values);

        sqDb.close();
    }

    private void update(SQLiteOpenHelper helper) {
    }

    private void delete(SQLiteOpenHelper helper) {
    }

    private void query(SQLiteOpenHelper helper) {

        SQLiteDatabase sqDb = helper.getReadableDatabase();

        Cursor cursor = sqDb.query(DbHelper.Database.TAB_CAR, null, null, null, null, null, null);

        while(cursor.moveToNext()){

            String carName = cursor.getString(cursor.getColumnIndex(DbHelper.Database.COL_CAR_NAME));
            String carOwner = cursor.getString(cursor.getColumnIndex(DbHelper.Database.COL_CAR_OWNER));
            Integer carVer = cursor.getInt(cursor.getColumnIndex(DbHelper.Database.COL_CAR_VER));
            Log.i(TAG,"Car Name - "+carName);
            Log.i(TAG,"Car Owner - "+carOwner);
            Log.i(TAG,"Car Ver - "+carVer);
        }

        sqDb.close();
    }

    private class Click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
        }
    }
}
