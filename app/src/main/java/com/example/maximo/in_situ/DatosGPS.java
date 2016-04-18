package com.example.maximo.in_situ;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by MAXIMO on 17-04-2016.
 */
public class DatosGPS extends Activity {

    public static String lat = "0", lon = "0", pres = "0", fecha, tipo;
    Location localizacion;
    Location localizacion2;
    LocationManager locManager;


    public void datos_gps() {
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        localizacion = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        localizacion2 = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (localizacion != null) {
            lat = String.valueOf(localizacion.getLatitude());
            lon = String.valueOf(localizacion.getLongitude());
            pres = String.valueOf(localizacion.getAccuracy());
            tipo = "GPS";
            Toast.makeText(this,"LAT: "+lat+"\n LON: "+lon+"\n PRES: "+pres+"\n TIPO: "+tipo, Toast.LENGTH_LONG).show();
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
}
