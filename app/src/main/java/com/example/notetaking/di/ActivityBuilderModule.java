package com.example.notetaking.di;

import com.example.notetaking.ui.noteslist.NotesListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract NotesListActivity notesActivity();
}
