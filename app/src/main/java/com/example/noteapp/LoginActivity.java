package com.example.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.noteapp.nodes.NotesActivity;
import com.example.noteapp.utils.Constants;

public class
LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUserName = findViewById(R.id.editTextUserName);
        EditText editTextUserPassword = findViewById(R.id.editTextUserPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUserName.getText().toString();
                String userPassword = editTextUserPassword.getText().toString();

                if(userName.equals("michiski") && userPassword.equals("1407")) {
                    prefs.setPref(Constants.PREFS_USER, true); //nos permitira mantener las sesiones del usuario
                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    intent.putExtra("userName", userName);
                    intent.putExtra("userPassword", userPassword);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "User or password where incorrect, try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
