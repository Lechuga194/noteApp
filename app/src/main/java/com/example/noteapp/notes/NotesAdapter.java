package com.example.noteapp.notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.notes.models.Note;
import com.example.noteapp.utils.Constants;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    ArrayList<Note> noteList;
    Context context;

    public NotesAdapter(ArrayList<Note> noteList, Context context){
        this.noteList = noteList;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Definimos como se crea la vista (viewholder)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        //Define lo que pasa en el momento que ya se cargo la vista
        holder.textViewNoteTitle.setText(noteList.get(position).getTitulo());
        holder.textViewNoteBody.setText(noteList.get(position).getCuerpo());

        //Manejamos el evento de click
        holder.linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailNoteActivity.class);
                intent.putExtra(Constants.EXTRA_NOTE_TITLE, noteList.get(position).getTitulo());
                intent.putExtra(Constants.EXTRA_NOTE_BODY, noteList.get(position).getCuerpo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
