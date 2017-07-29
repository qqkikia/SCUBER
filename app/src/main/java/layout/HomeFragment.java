package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.macbook.scuber.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class HomeFragment extends Fragment implements OnMapReadyCallback{

    private GoogleMap mMap;

    Boolean pickupNowBoolean;
    Button pickupNow, pickupLater, flip;
    EditText fromEditText, toEditText;
    String fromString, toString;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        pickupNow = (Button) getView().findViewById(R.id.pickupNow);
        pickupLater = (Button) getView().findViewById(R.id.pickupLater);
        flip = (Button) getView().findViewById(R.id.flip);

        fromEditText = (EditText) getView().findViewById(R.id.fromEditText);
        toEditText = (EditText) getView().findViewById(R.id.toEditText);

        pickupNowBoolean = true;

        pickupNow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(pickupNowBoolean = false){
                    pickupNow.setTextColor(getResources().getColor(R.color.darkBlue));
                    pickupLater.setTextColor(getResources().getColor(R.color.grey));
                    pickupNowBoolean = true;
                }
            }
        });

        pickupLater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(pickupNowBoolean = true){
                    pickupNow.setTextColor(getResources().getColor(R.color.grey));
                    pickupLater.setTextColor(getResources().getColor(R.color.darkBlue));
                    pickupNowBoolean = false;
                }
            }
        });

        flip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                fromString = fromEditText.getText().toString();
                toString = toEditText.getText().toString();

                fromEditText.setText(toString);
                toEditText.setText(fromString);
            }
        });


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
