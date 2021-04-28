package com.example.noteapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.noteapp.utils.Constants;

public class DetailNoteActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);

        String nota = getIntent().getStringExtra(Constants.EXTRA_NOTE);
        TextView textViewNote = findViewById(R.id.textViewNoteBody);
        textViewNote.setText(nota);
    }
}
