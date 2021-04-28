package com.example.noteapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.noteapp.utils.PreferencesManager;

public abstract class BaseActivity extends AppCompatActivity {
    public PreferencesManager prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        prefs = new PreferencesManager(this);
    }
}
