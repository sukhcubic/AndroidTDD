package com.example.notetaking.ui.noteslist;

import android.os.Bundle;
import android.util.Log;

import com.example.notetaking.R;
import com.example.notetaking.repository.NoteRepository;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NotesListActivity extends DaggerAppCompatActivity {

    private static final String TAG = "NotesListActivity";

    @Inject
    NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + noteRepository);

    }
}