package com.example.maximo.in_situ;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/**
 * Created by MAXIMO on 07-04-2016.
 */
public class Configurar extends Activity {


    NavigationView navigationView;
    DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configurar_layout);

        //ORIENTACION DE LA PANTALLA
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);

    }
    public void click_camara_configurar(View view) {
        startActivity(new Intent(this, Camara.class));
    }
    public void click_mapa_configurar(View view){
        startActivity(new Intent(this, Mapa.class));
    }
    public void click_ayuda_configurar(View view) {
        startActivity(new Intent(this, FotosExplicacion_menu.class));
    }

    public void onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(navigationView);
        }else {
            drawer_layout.openDrawer(navigationView);
        }
        return;
    }

}
