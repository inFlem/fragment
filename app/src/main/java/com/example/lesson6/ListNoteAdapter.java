package com.example.lesson6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder>{

    private List<Note> notesList = NotesFramework.getListOfNotes();
    private Listener listener;

    public ListNoteAdapter(Listener listener) {
        this.listener = listener;
    }

//    public void setItems(List<Note> notes) {
//        notesList.addAll(notes);
//        notifyDataSetChanged();
//    }
//
//    public void clearItems() {
//        notesList.clear();
//        notifyDataSetChanged();
//    }
//
////notifyDataSetChanged - предназначен для того, чтобы перерисовать элементы на экране.



    @Override
    public ListNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_item, parent, false);
        return new ListNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListNoteAdapter.ListNoteViewHolder holder, int position) {
        holder.setText(notesList.get(position).getTitle());
        holder.setListener((view)-> listener.onNoteClick(notesList.get(position)));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    class ListNoteViewHolder extends RecyclerView.ViewHolder {

        private TextView listNoteView;

        public ListNoteViewHolder(View itemView) {
            super(itemView);

            listNoteView = itemView.findViewById(R.id.note_name);
        }

        public void setText(String text){
            listNoteView.setText(text);
        }

        public void setListener(View.OnClickListener listener){
            listNoteView.setOnClickListener(listener);
        }
    }

    interface Listener{
        void onNoteClick(Note note);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }
}
