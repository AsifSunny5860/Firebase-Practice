package com.example.myproject;

import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng banani = new LatLng(23.790290, 90.408189);
        LatLng dhanmondi = new LatLng(23.753128, 90.369969);
        LatLng gulshan1 = new LatLng(23.776900, 90.416843);
        LatLng gulshan2 =new LatLng(23.800443, 90.411873);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(gulshan2).title("Nandos Gulshan2"));
        mMap.addMarker(new MarkerOptions().position(gulshan1).title("Nandos Gulshan1"));
        mMap.addMarker(new MarkerOptions().position(banani).title("Nandos Banani"));
        mMap.addMarker(new MarkerOptions().position(dhanmondi).title("Nandos Dhanmondi"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dhanmondi,14));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(banani,14));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gulshan1,14));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gulshan2,14));
    }
}



