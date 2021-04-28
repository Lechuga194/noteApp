package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.noteapp.utils.Constants;

public class NotesActivity extends BaseActivity {
    ListView listViewNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setLogoutEvent();
        setListViewData();
    }

    /**
     * Metodo para manejar las notas
     */
    private void setListViewData(){
        listViewNotes = findViewById(R.id.listViewNotes);

        //Arreglo para manejar las notas, recibe el contexto y una vista (predeterminada de android)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(NotesActivity.this, android.R.layout.simple_list_item_1);
        listViewNotes.setAdapter(adapter);
        

    }

    /**
     * Metodo para manejar el cierre de sesion mediante el boton
     */
    private void setLogoutEvent() {
        Button btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.setPref(Constants.PREFS_USER, false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}