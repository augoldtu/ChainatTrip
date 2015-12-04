package com.example.lekkongsuntea.neramit.chainattrip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String latString, lngString, iconString = "Hotel", titleString;
    private double latADouble, lngADouble;
    private LatLng centerLatLng;
    private int imageMakerAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //Receive Value From Intent
        receiveValue();

        //Choose Image Maker
        chooseImageMarker();

        //Create LatLng
        createLatLng();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }   // Main Method

    private void chooseImageMarker() {

        if (iconString.equals("Hotel")) {
            imageMakerAnInt = R.drawable.build1;
        } else if (iconString.equals("Restaurant")) {
            imageMakerAnInt = R.drawable.build2;
        } else if (iconString.equals("Souvenir")) {
            imageMakerAnInt = R.drawable.build3;
        } else {
            imageMakerAnInt = R.drawable.build4;
        }

    }   // chooseImageMarker

    private void createLatLng() {

        centerLatLng = new LatLng(latADouble, lngADouble);

    }

    private void receiveValue() {

        latString = getIntent().getStringExtra("Lat");
        lngString = getIntent().getStringExtra("Lng");
        latADouble = Double.parseDouble(latString);
        lngADouble = Double.parseDouble(lngString);
        iconString = getIntent().getStringExtra("Icon");
        titleString = getIntent().getStringExtra("Title");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Setup Center of Map to LatLng
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLatLng, 16));

        //Create Marker
        mMap.addMarker(new MarkerOptions()
                .position(centerLatLng)
                .icon(BitmapDescriptorFactory.fromResource(imageMakerAnInt))
        .title(titleString));



    }   // onMapReady

}   // Main Class