package com.example.lekkongsuntea.neramit.chainattrip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChainatListview extends AppCompatActivity {

    //Expicit
    private String[] titleStrings, shortDetailStrings,
    URLimage1Strings, URLimage2Strings, URLimage3Strings,
            LongDetailStrings, LatStrings, LngStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chainat_listview);

        //Create ListView
        createListView();

    }  //main method

    private void createListView() {

        //Read SQLite Form Where Hotel, ......
        final String strCategory = getIntent().getStringExtra("Category");

        //Read All Data
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("Chainat.db", MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM chainatTABLE WHERE Category = " + "'" + strCategory + "'", null);

        objCursor.moveToFirst();
        int intCursor = objCursor.getCount();
        titleStrings = new String[intCursor];
        shortDetailStrings = new String[intCursor];
        URLimage1Strings = new String[intCursor];
        URLimage2Strings = new String[intCursor];
        URLimage3Strings = new String[intCursor];
        LongDetailStrings = new String[intCursor];
        LatStrings = new String[intCursor];
        LngStrings = new String[intCursor];

        for (int i = 0; i < intCursor; i++) {

            titleStrings[i] = objCursor.getString(objCursor.getColumnIndex("Title"));
            shortDetailStrings[i] = objCursor.getString(objCursor.getColumnIndex("ShortDetail"));
            URLimage1Strings[i] = objCursor.getString(objCursor.getColumnIndex("URLimage1"));
            URLimage2Strings[i] = objCursor.getString(objCursor.getColumnIndex("URLimage2"));
            URLimage3Strings[i] = objCursor.getString(objCursor.getColumnIndex("URLimage3"));
            LongDetailStrings[i] = objCursor.getString(objCursor.getColumnIndex("LongDeteil"));
            LatStrings[i] = objCursor.getString(objCursor.getColumnIndex("Lat"));
            LngStrings[i] = objCursor.getString(objCursor.getColumnIndex("Lng"));

            objCursor.moveToNext();


        } //for

        objCursor.close();

        MyAdapter objMyAdapter = new MyAdapter(ChainatListview.this, URLimage1Strings, shortDetailStrings, titleStrings);
        ListView objListView = (ListView) findViewById(R.id.listView);
        objListView.setAdapter(objMyAdapter);

        objListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Intent to DetailActivity
                Intent objIntent = new Intent(ChainatListview.this, DetailActivity.class);
                objIntent.putExtra("Title", titleStrings[i]);
                objIntent.putExtra("Image1", URLimage1Strings[i]);
                objIntent.putExtra("Image2", URLimage2Strings[i]);
                objIntent.putExtra("Image3", URLimage3Strings[i]);
                objIntent.putExtra("Detail", LongDetailStrings[i]);
                objIntent.putExtra("Lat", LatStrings[i]);
                objIntent.putExtra("Lng", LngStrings[i]);
                objIntent.putExtra("Icon", strCategory);
                startActivity(objIntent);



            } //event


        });


    } //create listview

}  //main class
