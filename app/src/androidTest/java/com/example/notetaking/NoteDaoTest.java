package com.example.notetaking;

import android.database.sqlite.SQLiteConstraintException;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.notetaking.models.Note;
import com.example.notetaking.persistence.NoteDao;
import com.example.notetaking.util.LiveDataTestUtil;
import com.example.notetaking.util.TestUtil;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class NoteDaoTest extends NoteDatabaseTest {


    public static final String TEST_TITLE = "This is a test title";
    public static final String TEST_CONTENT = "This is some test content";
    public static final String TEST_TIMESTAMP = "08-2018";

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Test
    public void insertReadDelete() throws Exception {
        Note note = new Note(TestUtil.TEST_NOTE_1);

        getNoteDao().insertNote(note).blockingGet();

        LiveDataTestUtil<List<Note>> liveDataTestUtil  = new LiveDataTestUtil<>();

        List<Note> insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());

        assertNotNull(insertedNotes);
        assertEquals(note.getContent(), insertedNotes.get(0).getContent());
        assertEquals(note.getTimeStamp(), insertedNotes.get(0).getTimeStamp());
        assertEquals(note.getTitle(), insertedNotes.get(0).getTitle());

        note.setId(insertedNotes.get(0).getId());
        assertEquals(note, insertedNotes.get(0));

        // delete
        getNoteDao().deleteNote(note).blockingGet();

        // confirm the database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());
        assertEquals(0, insertedNotes.size());

    }

    /*
    Insert, Read, Update, Read, Delete,
 */
    @Test
    public void insertReadUpdateReadDelete() throws Exception{

        Note note = new Note(TestUtil.TEST_NOTE_1);

        // insert
        getNoteDao().insertNote(note).blockingGet(); // wait until inserted

        // read
        LiveDataTestUtil<List<Note>> liveDataTestUtil = new LiveDataTestUtil<>();
        List<Note> insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());

        assertNotNull(insertedNotes);

        assertEquals(note.getContent(), insertedNotes.get(0).getContent());
        assertEquals(note.getTimeStamp(), insertedNotes.get(0).getTimeStamp());
        assertEquals(note.getTitle(), insertedNotes.get(0).getTitle());

        note.setId(insertedNotes.get(0).getId());
        assertEquals(note, insertedNotes.get(0));

        // update
        note.setTitle(TEST_TITLE);
        note.setContent(TEST_CONTENT);
        note.setTimeStamp(TEST_TIMESTAMP);
        getNoteDao().updateNote(note).blockingGet();

        // read
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());

        assertEquals(TEST_TITLE, insertedNotes.get(0).getTitle());
        assertEquals(TEST_CONTENT, insertedNotes.get(0).getContent());
        assertEquals(TEST_TIMESTAMP, insertedNotes.get(0).getTimeStamp());

        note.setId(insertedNotes.get(0).getId());
        assertEquals(note, insertedNotes.get(0));

        // delete
        getNoteDao().deleteNote(note).blockingGet();

        // confirm the database is empty
        insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());
        assertEquals(0, insertedNotes.size());
    }



    /*
        Insert note with null title, throw exception
     */
    @Test(expected = SQLiteConstraintException.class)
    public void insert_nullTitle_throwSQLiteConstraintException() throws Exception{

        final Note note = new Note(TestUtil.TEST_NOTE_1);
        note.setTitle(null);

        // insert
        getNoteDao().insertNote(note).blockingGet();
    }


    /*
        Insert, Update with null title, throw exception
     */

    @Test(expected = SQLiteConstraintException.class)
    public void updateNote_nullTitle_throwSQLiteConstraintException() throws Exception{

        Note note = new Note(TestUtil.TEST_NOTE_1);

        // insert
        getNoteDao().insertNote(note).blockingGet();

        // read
        LiveDataTestUtil<List<Note>> liveDataTestUtil = new LiveDataTestUtil<>();
        List<Note> insertedNotes = liveDataTestUtil.getValue(getNoteDao().getNotes());
        assertNotNull(insertedNotes);

        // update
        note = new Note(insertedNotes.get(0));
        note.setTitle(null);
        getNoteDao().updateNote(note).blockingGet();

    }
}
