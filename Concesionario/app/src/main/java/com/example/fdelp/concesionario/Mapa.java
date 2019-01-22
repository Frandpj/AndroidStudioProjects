package com.example.fdelp.concesionario;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        //Si los servicios de GooglePlay estan funcionando correctamente, entra.
        if(status == ConnectionResult.SUCCESS){

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
        else{ //Si no, entran aqui.

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, (Activity)getApplicationContext(), 10);
            dialog.show();

        }


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

        //Selecciona el mapa que nos va a mostrar, en nuestro caso va a ser el normal.
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Activa las utilidades de googlemaps.
        UiSettings uiSettings = mMap.getUiSettings();
        //Activa el zoom de googlemaps.
        uiSettings.setZoomControlsEnabled(true);

        //Se ubica en zafiro.
        LatLng zafiro = new LatLng(37.579459, -4.635705);
        mMap.addMarker(new MarkerOptions().position(zafiro).title("Aquí estamos situados."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(zafiro));

        //Establece un nivel de zoom por defecto.
        float nivelZoom = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zafiro, nivelZoom));
    }
}
