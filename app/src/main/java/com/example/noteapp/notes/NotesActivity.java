package com.example.noteapp.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.BaseActivity;
import com.example.noteapp.LoginActivity;
import com.example.noteapp.R;
import com.example.noteapp.notes.models.Note;
import com.example.noteapp.utils.Constants;

import java.util.ArrayList;

public class NotesActivity extends BaseActivity {
    RecyclerView recycleViewNotes;
    ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setLogoutEvent();
        setRecycleViewData();
    }

    private void populateNoteList(){
        noteList = new ArrayList<>();
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
        noteList.add(new Note("Terminar Codigo", "Verificar lo que falta"));
    }

    /**
     * Metodo para manejar las notas
     */
    private void setRecycleViewData(){
        recycleViewNotes = findViewById(R.id.recycleViewNotes); //Componente Recycleview instanciado del layout

        this.populateNoteList();

        //Adapter que se encarga de manejar la info del Recycleview
        NotesAdapter adapter = new NotesAdapter(noteList, NotesActivity.this);
        recycleViewNotes.setAdapter(adapter);

        recycleViewNotes.setHasFixedSize(true); //Dice que los datos no cambiaran en runtime

        //Define como se dispone el recycleview segun la vista
        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);
        recycleViewNotes.setLayoutManager(manager);
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