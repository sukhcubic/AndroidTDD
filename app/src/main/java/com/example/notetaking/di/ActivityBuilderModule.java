package com.example.notetaking.di;

import com.example.notetaking.NotesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract NotesActivity notesActivity();
}
