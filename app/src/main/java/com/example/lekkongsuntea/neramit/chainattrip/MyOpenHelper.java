package com.example.lekkongsuntea.neramit.chainattrip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by augold on 2/12/2558.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "Chainat.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_CHAINAT_TABLE = "create table chainatTABLE (_id integer primary key, " +
            "Category text, " +
            "Title text, " +
            "ShortDetail text, " +
            "URLimage1 text, " +
            "URLimage2 text, " +
            "URLimage3 text, " +
            "LongDeteil text, " +
            "Lat text, " +
            "Lng text);";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }  //Constructer

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CHAINAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}  //Main Class
