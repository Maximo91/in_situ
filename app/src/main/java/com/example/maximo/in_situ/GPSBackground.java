package com.example.maximo.in_situ;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

public class GPSBackground extends Service {

    public static String lat = "0", lon = "0", pres = "0", fecha, tipo;
    Location localizacion;
    Location localizacion2;
    LocationManager locManager;

    public void GPSBackground() {
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //cent = false;
            }
        }
        localizacion = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        localizacion2 = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (localizacion != null) {
            lat = String.valueOf(localizacion.getLatitude());
            lon = String.valueOf(localizacion.getLongitude());
            pres = String.valueOf(localizacion.getAccuracy());
            tipo = "GPS";
            Toast.makeText(this, "LAT: " + lat + "\n LON: " + lon + "\n PRES: " + pres + "\n TIPO: " + tipo, Toast.LENGTH_LONG).show();
        } else if (localizacion2 != null) {
            lat = String.valueOf(localizacion2.getLatitude());
            lon = String.valueOf(localizacion2.getLongitude());
            pres = String.valueOf(localizacion2.getAccuracy());
            tipo = "WIFI";
            Toast.makeText(this,"LAT: "+lat+"\n LON: "+lon+"\n PRES: "+pres+"\n TIPO: "+tipo, Toast.LENGTH_LONG).show();

        } else {
            lat = "0";
            lon = "0";
            pres = "0";
            tipo = null;
            Toast.makeText(this,"LAT: "+lat+"\n LON: "+lon+"\n PRES: "+pres+"\n TIPO: "+tipo, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
