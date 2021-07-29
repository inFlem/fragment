package com.example.lesson6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class NameFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListNoteAdapter listNoteAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        recyclerView = view.findViewById(R.id.rv_note);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        listNoteAdapter = new ListNoteAdapter((ListNoteAdapter.Listener) getActivity());

        recyclerView.setAdapter(listNoteAdapter);

        return view;
    }
}