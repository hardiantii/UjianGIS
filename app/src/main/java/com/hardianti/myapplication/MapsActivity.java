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
        LatLng rumah = new LatLng(-0.905528, 119.895435);
        LatLng apotik_garuda = new LatLng(-0.90634, 119.89849);
        LatLng apotik_kimia = new LatLng(-0.8984905, 119.8945723);
        LatLng apotik_Sehat_Sentosa = new LatLng(-0.9191181, 119.8951155);
        LatLng apotik_Diva_Farma = new LatLng(-0.8966845, 119.8816410);
        LatLng apotik_Pelangi = new LatLng(-0.9187098, 119.8896434);
        //custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable) getResources().getDrawable(R.drawable.rumah);
        BitmapDrawable bitmapDes = (BitmapDrawable) getResources().getDrawable(R.drawable.apotik1);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap MarkerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap MarkerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add market to map
        mMap.addMarker(new MarkerOptions().position(rumah).title("Rumah")
                .snippet("Ini adalah Rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerStart)));

        mMap.addMarker(new MarkerOptions().position(apotik_garuda).title("Apotik Garuda")
        .snippet("Ini adalah Apotik Garuda")
        .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(apotik_kimia).title("Apotik Kimia Farma")
                .snippet("Ini adalah Apotik Kimia Farma")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(apotik_Sehat_Sentosa).title("Apotik Sehat Sentosa")
                .snippet("Ini adalah Apotik Sehat Sentosa")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(apotik_Diva_Farma).title("Apotik Diva Farma")
                .snippet("Ini adalah Apotik Diva Farma")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addMarker(new MarkerOptions().position(apotik_Pelangi).title("Apotik Pelangi")
                .snippet("Ini adalah Apotik Pelangi")
                .icon(BitmapDescriptorFactory.fromBitmap(MarkerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-0.905528, 119.895435),
                new LatLng(-0.905611, 119.895409),
                new LatLng(-0.905570, 119.895635),
                new LatLng(-0.904994, 119.895576),
                new LatLng(-0.904844, 119.896186),
                new LatLng(-0.904633, 119.896977),
                new LatLng(-0.904491, 119.897608),
                new LatLng(-0.904368, 119.898188),
                new LatLng(-0.905199, 119.898292),
                new LatLng(-0.906245, 119.898389),
                new LatLng(-0.906351, 119.898399),
                new LatLng(-0.90634, 119.89849),
                apotik_garuda
                ).width(10)
                .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(apotik_garuda, 14.5f));
    }
}