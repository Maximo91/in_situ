package com.example.maximo.in_situ;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by MAXIMO on 27-03-2016.
 */
public class Camara extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Sacar el action bar
        getSupportActionBar().hide();

    }

    //OPCIONES MENU DRAWER LAYOUT
    public void click_mapa_camara(View view){
        startActivity(new Intent(this, Mapa.class));
    }
    public void click_ayuda_camara(View view){
        startActivity(new Intent(this, FotosExplicacion_menu.class));
    }
    public void click_configurar_camara(View view) {
        startActivity(new Intent(this, Configurar.class));
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
