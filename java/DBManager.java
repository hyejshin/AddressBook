package com.example.hyejung.p1315842_10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HyeJung on 2015-11-10.
 */
public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table addressBook (idx integer primary key autoincrement, name text, gender text, coding text, sports text, traveling text," +
                "movie text, phone text, address text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}