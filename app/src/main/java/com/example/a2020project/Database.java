package com.example.a2020project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

import java.util.Date;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABALE_NAME = "register.db";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Fullname";
    public static final String COL_3 = "Lastname";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "DOB";
    public static final String COL_6 = "Password";
    public static final String COL_7 = "CfPassword";

    String creatTable = "CREATE TABLE if not exists `register` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Fullname` TEXT, `Lastname` TEXT, `Email` TEXT, `DOB` TEXT, `Password` TEXT, `CfPassword` TEXT)";



    public Database(Context context) {
        super(context, DATABASE_NAME, null,1 );
        getWritableDatabase().execSQL(creatTable);
    }

    public void addUser(ContentValues contentValues){
        getWritableDatabase().insert("register","",contentValues);
    }

    public boolean isLoginValid(String email, String password){
        String sql = "Select count(*) from register where email = '" + email + "' and password ='" + password + "'";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long statementLong = statement.simpleQueryForLong();
        statement.close();

        if (statementLong == 1){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

//    public long registerUser (String Fullname, String Lastname , String Email , String DOB , String Password , String CfPassword){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Fullname", Fullname);
//        contentValues.put("Lastname", Lastname);
//        contentValues.put("Email", Email);
//        contentValues.put("DOB", DOB);
//        contentValues.put("Password", Password);
//        contentValues.put("CfPassword", CfPassword);
//
//        long regis = db.insert("register", null, contentValues);
//        db.close();
//
//        return regis;
//
//    }

//    public boolean validation(String Fullname, String Lastname , String Email , String DOB , String Password , String CfPassword){
//        String[] columns = {COL_1};
//        SQLiteDatabase db = getReadableDatabase();
//        String select = COL_4 + "=?" + " and " + COL_6 + "=?";
//        String[] selection = { Email, Password};
//        Cursor cursor = db.query(TABALE_NAME, columns, select, selection, null,null, null);
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if(count > 0)
//            return true;
//        else
//            return false;
//
//    }
}
