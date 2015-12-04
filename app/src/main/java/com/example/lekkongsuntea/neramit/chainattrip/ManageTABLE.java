package com.example.lekkongsuntea.neramit.chainattrip;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by augold on 2/12/2558.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String CHAINAT_TABLE = "chainatTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_SHORT_DETEIL = "ShortDetail";
    public static final String COLUMN_URU_IMAGE1 = "URLimage1";
    public static final String COLUMN_URU_IMAGE2 = "URLimage2";
    public static final String COLUMN_URU_IMAGE3 = "URLimage3";
    public static final String COLUMN_LONG_DETEIL = "LongDeteil";
    public static final String COLUMN_LAT = "Lat";
    public static final String COLUMN_LNG = "Lng";


    public ManageTABLE(Context context) {

        //Create & connected
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   //constructor



    // Add Value to chainattable
    public long addValueToSQLite(String strCategory,
                                 String strTitle,
                                 String strShotDetail,
                                 String strURLimage1,
                                 String strURLimage2,
                                 String strURLimage3,
                                 String strLongDeteil,
                                 String strLat,
                                 String strLng) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CATEGORY, strCategory);
        objContentValues.put(COLUMN_TITLE, strTitle);
        objContentValues.put(COLUMN_SHORT_DETEIL, strShotDetail);
        objContentValues.put(COLUMN_URU_IMAGE1, strURLimage1);
        objContentValues.put(COLUMN_URU_IMAGE2, strURLimage2);
        objContentValues.put(COLUMN_URU_IMAGE3, strURLimage3);
        objContentValues.put(COLUMN_LONG_DETEIL, strLongDeteil);
        objContentValues.put(COLUMN_LAT, strLat);
        objContentValues.put(COLUMN_LNG, strLng);

        return writeSqLiteDatabase.insert(CHAINAT_TABLE, null, objContentValues);
    }

}  //main class
