package com.example.a2020project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABALE_NAME = "register.db";
    public static final String COL_1 = "Fullname";
    public static final String COL_2 = "Lastname";
    public static final String COL_3 = "Email";
    public static final String COL_4 = "DOB";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "CfPassword";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (ID INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
