package com.example.maximo.in_situ;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;

import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

/**
 * @author Vlonjat Gashi (vlonjatg)
 */
public class FotosExplicacion_menu extends AppTour {

    @Override
    public void init(Bundle savedInstanceState) {

        //setTheme(R.style.);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int heigth = displayMetrics.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(heigth*.6));


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Sacar el action bar
        getSupportActionBar().hide();
        int firstColor = Color.parseColor("#CDCDCD");
        int secondColor = Color.parseColor("#CDCDCD");
        int thirdColor = Color.parseColor("#CDCDCD");
        //int forthColor = Color.parseColor("#CDCDCD");
        //int customSlideColor = Color.parseColor("#009866");

        //Create pre-created fragments
        Fragment firstSlide = MaterialSlide.newInstance(R.drawable.menu_inicio_gris, "Menú Principal",
                "Contiene el acceso a las distintas opciones que " +
                "ofrece la aplicación.", Color.BLACK, Color.BLACK);

        Fragment secondSlide = MaterialSlide.newInstance(R.drawable.mapa_fondo_gris2,"Mapa Georreferenciado",
                "Localiza los naufragios en Valparaíso, generando un " +
                        "vinculo con la información presentada a la distacia del usuario.", Color.BLACK, Color.BLACK);

        Fragment thirdSlide = MaterialSlide.newInstance(R.drawable.camara_fondo_gris, "Camara Interactiva",
                "Presentar con realidad aumentada el naufragio y un menu con información del naufragio.", Color.BLACK, Color.BLACK);

        //Fragment forthSlide = MaterialSlide.newInstance(R.drawable.gs_snc_single_nonconforming_box_img_default, "Titulo Imagen 04",
        //       "Explicacion Imagen 04", Color.BLACK, Color.BLACK);

        //Add slides
        addSlide(firstSlide, firstColor);
        addSlide(secondSlide, secondColor);
        addSlide(thirdSlide, thirdColor);
        //addSlide(forthSlide, forthColor);

        //Custom slide
        //addSlide(new CustomSlide(), customSlideColor);

        //Customize tour
        setSkipButtonTextColor(Color.GRAY);
        setSkipText("Finalizar");
        setNextButtonColorToWhite();
        setDoneButtonTextColor(Color.GRAY);
        setDoneText("Aceptar");
    }

    @Override
    public void onSkipPressed() {
        //Toast.makeText(this, "Skip", Toast.LENGTH_SHORT).show();
        //Do something after clicking Skip button.
        //E.x: Go to the sign up slide.
        setCurrentSlide(4);
    }

    @Override
    public void onDonePressed() {
        closeContextMenu();
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
