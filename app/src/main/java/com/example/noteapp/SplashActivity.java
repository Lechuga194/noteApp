package com.example.noteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
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
                SharedPreferences prefs = getSharedPreferences("prefs_appNote", MODE_PRIVATE); //Llama a las preferencias guardadas
                boolean isUserLogged = prefs.getBoolean("isUserLogged", false);
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
