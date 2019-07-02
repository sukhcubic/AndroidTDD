package com.example.notetaking.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteTest {

    public static final String TIMESTAMP_1 = "08-2019";
    public static final String TIMESTAMP_2 = "09-2019";


    @Test
    void isNoteEqual() throws Exception {
        Note note1 = new Note(1,"Note 1", "This is One",TIMESTAMP_1 );
        Note note2 = new Note(1,"Note 1", "This is One",TIMESTAMP_2 );


        //Assert
        Assertions.assertEquals(note1, note2);
        System.out.println("Notes are equal");
    }


    @Test
    void diffId() throws Exception {
        Note note1 = new Note(1,"Note 1", "This is One",TIMESTAMP_1 );
        Note note2 = new Note(2,"Note 1", "This is One",TIMESTAMP_2 );


        //Assert
        Assertions.assertNotEquals(note1, note2);
        System.out.println("Notes are not equal");
    }

    //Checking Timestamp
    @Test
    void diffTime() throws Exception {
        Note note1 = new Note(1,"Note 1", "This is One",TIMESTAMP_1 );
        Note note2 = new Note(1,"Note 1", "This is One",TIMESTAMP_1 );


        //Assert
        Assertions.assertEquals(note1, note2);
        System.out.println("Notes are equal");
    }

    //Title
    @Test
    void diffTitle() throws Exception {
        Note note1 = new Note(1,"Note 1", "This is One",TIMESTAMP_1 );
        Note note2 = new Note(1,"Note 2", "This is One",TIMESTAMP_1 );


        //Assert
        Assertions.assertNotEquals(note1, note2);
        System.out.println("Notes are not equal");
    }

    //Title
    @Test
    void diffContent() throws Exception {
        Note note1 = new Note(1,"Note 1", "This is One",TIMESTAMP_1 );
        Note note2 = new Note(1,"Note 2", "This is Sample two",TIMESTAMP_1 );


        //Assert
        Assertions.assertNotEquals(note1, note2);
        System.out.println("Notes are not equal");
    }
}

