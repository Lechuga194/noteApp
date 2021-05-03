package com.example.noteapp.notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.BaseActivity;
import com.example.noteapp.LoginActivity;
import com.example.noteapp.R;
import com.example.noteapp.notes.models.Note;
import com.example.noteapp.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NotesActivity extends BaseActivity {
    RecyclerView recycleViewNotes;
    ArrayList<Note> noteList = new ArrayList<>();
    int REQUEST_CODE = 1;
    private final String SHARED_PREFERENCE_NAME = "sharedPreferenceListOfNotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setLogoutEvent();
        setNewNoteEvent();
        setRecycleViewData();
    }

    //https://www.geeksforgeeks.org/how-to-save-arraylist-to-sharedpreferences-in-android/
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("notes", null);
        Type type = new TypeToken<ArrayList<Note>>(){}.getType();
        noteList = gson.fromJson(json, type);
        if(noteList == null)
            noteList = new ArrayList<>();
    }

    //https://www.geeksforgeeks.org/how-to-save-arraylist-to-sharedpreferences-in-android/
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(noteList);
        editor.putString("notes", json);
        editor.apply();
        //Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo para manejar las notas
     */
    private void setRecycleViewData(){
        recycleViewNotes = findViewById(R.id.recycleViewNotes); //Componente Recycleview instanciado del layout

        this.loadData();

        //Adapter que se encarga de manejar la info del Recycleview
        NotesAdapter adapter = new NotesAdapter(noteList, NotesActivity.this);
        recycleViewNotes.setAdapter(adapter);

        //recycleViewNotes.setHasFixedSize(true); //Dice que los datos no cambiaran en runtime

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

    /**
     * Metodo para manejar el boton de ADD NOTE
     */
    private void setNewNoteEvent(){
        Button btnAddNote = findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("***************************************");
                Intent intent = new Intent(NotesActivity.this, NotesAddNote.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Note newnote = new Note(data.getStringExtra("title"), data.getStringExtra("body"));
        noteList.add(newnote);
        this.saveData();
        this.setRecycleViewData();
    }


}