package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements ListNoteAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new NameFragment())
                .commit();
    }

    @Override
    public void onNoteClick(Note note) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, ContentFragment.getInstance(note)).commit();
    }
}