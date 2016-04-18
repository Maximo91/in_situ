package com.example.maximo.in_situ;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.*;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by MAXIMO on 27-03-2016.
 */
public class MenuPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuprincipal_layout);

        //ORIENTACION DE LA PANTALLA
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Sacar el action bar
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    //Bloquear boton back del celular
    @Override
    public void onBackPressed() {
        return;
    }

    //Onclick boton Mapa
    public void Click_Mapa(View v){
        startActivity(new Intent(this, Mapa.class));
    }

    //Onclick boton Camara
    public void Click_Camara(View v){
        startActivity(new Intent(this, Camara.class));
    }

    //Onclick boton Salir
    public void Click_Salir(View v){
        startActivity(new Intent(this, Configurar.class));
    }

    public void Click_tutorial(View v){
        startActivity(new Intent(this, FotosExplicacion.class));
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
