package com.example.lesson6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContentFragment extends Fragment {
    public static final String NOTE_ID = "com.example.lesson6.ContentFragment.NOTE_ID";
    private TextView titleTextView;
    private TextView contentTextView;
    private Note note;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container,  false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        note = getArguments().getParcelable(NOTE_ID);
        initList(view);
    }

    private void initList(View view) {
        titleTextView = view.findViewById(R.id.note_name);
        contentTextView = view.findViewById(R.id.note_content);

        titleTextView.setText(note.getTitle());
        contentTextView.setText(note.getText());
    }

    static ContentFragment getInstance(Note note){
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(contentFragment.NOTE_ID, note);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }
}
