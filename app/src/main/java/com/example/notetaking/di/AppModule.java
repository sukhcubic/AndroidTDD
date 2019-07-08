package com.example.notetaking.di;

import android.app.Application;

import androidx.room.Room;

import com.example.notetaking.persistence.NoteDao;
import com.example.notetaking.persistence.NoteDatabase;
import com.example.notetaking.repository.NoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.notetaking.persistence.NoteDatabase.DATABASE_NAME;

@Module
class AppModule {

    @Singleton
    @Provides
    static NoteDatabase provideNoteDatabase(Application application){
        return Room.databaseBuilder(
                application,
                NoteDatabase.class,
                DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    static NoteDao providerNoteDao(NoteDatabase noteDatabase){
        return  noteDatabase.getNoteDao();
    }

    @Singleton
    @Provides
    static NoteRepository provideNoteRepository(NoteDao noteDao){
        return new NoteRepository(noteDao);
    }
}
