package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.noteapp.nodes.NotesActivity;
import com.example.noteapp.utils.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        runSlplash();
    }

    /**
     * Metodo que se encarga de ejecutar el Splash
     */
    private void runSlplash(){
        /**
         * Ejecucion de codigo asincrono
         */
        final Runnable splash = new Runnable() {
            @Override
            public void run() {
                boolean isUserLogged = prefs.getPref(Constants.PREFS_USER); //Obtiene si el usuario esta logueado
                Intent intent = (isUserLogged) ? new Intent(SplashActivity.this, NotesActivity.class) : new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        /**
         * Elemento de timer
         */
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(splash); //Ejecuta en el hilo principal
            }
        };

        /**
         * Timer para correr el splash
         */
        Timer timer = new Timer();
        timer.schedule(timerTask, 2500);
    }
}
