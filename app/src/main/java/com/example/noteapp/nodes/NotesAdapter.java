package com.example.noteapp.nodes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.nodes.models.Note;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    ArrayList<Note> noteList;

    public NotesAdapter(ArrayList<Note> noteList){
        this.noteList = noteList;
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
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
