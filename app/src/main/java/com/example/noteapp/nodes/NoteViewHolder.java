package com.example.noteapp.nodes;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    LinearLayout linearLayoutContainer;
    TextView textViewNoteTitle, textViewNoteBody;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);
        textViewNoteTitle = itemView.findViewById(R.id.textViewNoteTitle);
        textViewNoteBody = itemView.findViewById(R.id.textViewNoteBody);
    }
}
