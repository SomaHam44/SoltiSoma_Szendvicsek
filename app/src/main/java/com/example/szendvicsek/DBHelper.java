package com.example.szendvicsek;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "szendvics.db";
    private static final int version = 1;
    private static final String TABLE_NAME = "szendvicsek";
    private static final String COL_ID = "id";
    private static final String COL_NEV = "nev";
    private static final String COL_LEIRAS = "leiras";
    private static final String COL_ELKESZITES = "elkeszites";
    private static final String COL_AR = "ar";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + TABLE_NAME + " ( " + COL_ID
                + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    COL_NEV + " TEXT NOT NULL, " + COL_LEIRAS +
                " TEXT NOT NULL, " + COL_ELKESZITES + " INTEGER NOT NULL, " +
                COL_AR + " INTEGER NOT NULL " + ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}