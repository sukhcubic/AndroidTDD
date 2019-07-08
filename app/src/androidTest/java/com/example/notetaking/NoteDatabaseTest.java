package com.example.notetaking;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.notetaking.models.Note;
import com.example.notetaking.persistence.NoteDao;
import com.example.notetaking.persistence.NoteDatabase;
import com.example.notetaking.util.TestUtil;

import org.junit.After;
import org.junit.Before;

public abstract class NoteDatabaseTest {

    private NoteDatabase noteDatabase;

    public NoteDao getNoteDao(){
        return noteDatabase.getNoteDao();
    }

    @Before
    public void init(){
        //ApplicationProvider provides ability to retrieve the current application in tests.
        noteDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), NoteDatabase.class).build();
    }

    @After
    public void finish(){
        noteDatabase.close();
    }
}
