package com.example.maximo.in_situ;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.*;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ORIENTACION DE LA PANTALLA
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Sacar el action bar
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imagen = (ImageView)findViewById(R.id.in_situ);
        imagen.setImageResource(R.drawable.logo_insitu);
        startActivity(new Intent(this, FotosExplicacion.class));

        /*
        SharedPreferences sp = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        String estado = sp.getString("estado","");
        if (estado.equals("true")){
            progress.dismiss();
            startActivity(new Intent(this, MenuPrincipal.class));
        }else {
            startActivity(new Intent(this, FotosExplicacion.class));
            progress.dismiss();
        }*/
    }

    @Override
    public void onBackPressed() {
        return;
    }


}
