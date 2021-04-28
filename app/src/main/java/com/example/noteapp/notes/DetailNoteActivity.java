package com.example.noteapp.notes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.noteapp.BaseActivity;
import com.example.noteapp.R;
import com.example.noteapp.utils.Constants;

public class DetailNoteActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);

        String noteTitle = getIntent().getStringExtra(Constants.EXTRA_NOTE_TITLE);
        String noteBody = getIntent().getStringExtra(Constants.EXTRA_NOTE_BODY);

        TextView textViewNoteTitle = findViewById(R.id.textViewNoteTitle);
        TextView textViewNoteBody = findViewById(R.id.textViewNoteBody);

        textViewNoteTitle.setText(noteTitle);
        textViewNoteBody.setText(noteBody);
    }
}
