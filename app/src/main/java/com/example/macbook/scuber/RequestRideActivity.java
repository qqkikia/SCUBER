package com.example.macbook.scuber;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class RequestRideActivity extends AppCompatActivity {
    private String currentAddress = "------";
    private GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride);
        gps = new GPSTracker(this);
        UpdateCurrentLocation(null);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i("TagSuccess", "Place: " + place.getName());

            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("TagFailure", "An error occurred: " + status);
            }
        });
    }

    public void UpdateCurrentLocation(View view){
        if(gps.isGPSEnabled){
            if(gps.canGetLocation()) {
                double lat = gps.getLatitude();
                double lng = gps.getLongitude();
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                try {
                    List<android.location.Address> addresses = geocoder.getFromLocation(lat, lng, 1);
                    currentAddress = addresses.get(0).getAddressLine(0);
                    TextView currentAddressTV = (TextView) findViewById(R.id.currentLocation);
                    currentAddressTV.setText(currentAddress);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else{
            gps.showSettingsAlert();

        }
    }

}
