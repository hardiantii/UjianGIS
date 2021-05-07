package com.hardianti.myapplication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //sets the map type to be "hybrid"
    //map.setMapType(GoogleMap.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Untad1 and move the camera
        LatLng Home = new LatLng(-0.8436239, 119.8976752);
        LatLng ATM_BNI_1 = new LatLng(-0.8360934, 119.8903794);
        LatLng ATM_BNI_2 = new LatLng(-0.8356922, 119.8954361);
        LatLng ATM_BNI_3 = new LatLng(-0.8581360, 119.8834774);
        LatLng ATM_BNI_4 = new LatLng(-0.8743870, 119.8746030);
        LatLng ATM_BNI_5 = new LatLng(-0.8886600, 119.8781525);
        //custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable) getResources().getDrawable(R.drawable.pin_rumah_biru);
        BitmapDrawable bitmapDes = (BitmapDrawable) getResources().getDrawable(R.drawable.pin_atm_biru);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap MarkerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap MarkerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add market to map
        mMap.addMarker(new MarkerOptions().position(Home).title("Marker in My Home")
                .snippet("Ini adalah Rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerStart)));

        mMap.addMarker(new MarkerOptions().position(ATM_BNI_1).title("Marker in ATM BNI UNTAD 1")
                .snippet("Ini adalah ATM BNI UNTAD 1")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(ATM_BNI_2).title("Marker in ATM BNI UNTAD 2")
                .snippet("Ini adalah ATM BNI UNTAD 2")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(ATM_BNI_3).title("Marker in ATM BNI UNDATA")
                .snippet("Ini adalah ATM BNI UNDATA")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(ATM_BNI_4).title("Marker in ATM BNI SPBU Yos Sudarso")
                .snippet("Ini adalah ATM BNI SPBU Yos Sudarso")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(ATM_BNI_5).title("Marker in ATM BNI BNS S.Parman")
                .snippet("Ini adalah ATM BNI BNS S.Parman")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                Home,
                new LatLng(-0.8435212, 119.8976736),
                new LatLng(-0.8435055, 119.8961028),
                new LatLng(-0.8435038, 119.8957012),
                new LatLng(-0.8434800, 119.8914412),
                new LatLng(-0.8434589, 119.8908528),
                new LatLng(-0.8425263, 119.8905835),
                new LatLng(-0.8409691, 119.8902513),
                new LatLng(-0.8404806, 119.8901678),
                new LatLng(-0.8369039, 119.8894949),
                new LatLng(-0.8363920, 119.8893762),
                new LatLng(-0.8363511, 119.8893232),
                new LatLng(-0.8363079, 119.8892924),
                new LatLng(-0.8362434, 119.8892778),
                new LatLng(-0.8361993, 119.8892806),
                new LatLng(-0.8361603, 119.8893011),
                new LatLng(-0.8361245, 119.8893293),
                new LatLng(-0.8360967, 119.8893806),
                new LatLng(-0.8360860, 119.8894463),
                new LatLng(-0.8360965, 119.8894817),
                new LatLng(-0.8361201, 119.8895415),
                new LatLng(-0.8361714, 119.8902654),
                new LatLng(-0.8361794, 119.8903700),
                ATM_BNI_1
                ).width(10)
                .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ATM_BNI_1, 14.5f));
    }
}
