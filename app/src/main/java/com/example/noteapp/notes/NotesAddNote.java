package com.example.noteapp.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.noteapp.BaseActivity;
import com.example.noteapp.R;
import com.example.noteapp.notes.models.Note;

public class NotesAddNote extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);

        EditText editTextNewNoteTitle = findViewById(R.id.editTextNewNoteTitle);
        EditText editTextNewNoteBody = findViewById(R.id.editTextNewNoteBody);
        Button btnCreateNote = findViewById(R.id.btnCreateNote);

        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextNewNoteTitle.getText().toString();
                String body = editTextNewNoteBody.getText().toString();

                if(!title.isEmpty()){
                    Intent intent = new Intent(NotesAddNote.this, NotesActivity.class);
                    intent.putExtra("title",title);
                    intent.putExtra("body",body);
                    setResult(RESULT_OK, intent);
                    finish();
                }else
                    Toast.makeText(NotesAddNote.this, "Agrega un titulo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
