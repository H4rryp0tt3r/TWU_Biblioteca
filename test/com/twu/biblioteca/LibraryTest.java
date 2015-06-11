package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ArrayList<Book> listOfBooks = new ArrayList<>();;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        listOfBooks.add(new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.add(new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.add(new Book("Sample Book3", "Ganesh", "2011"));
    }

    @Test
    public void shouldBeAbleToDisplayBooksByDetails() {
        Library library = new Library(listOfBooks);
        library.displayBookListWithAllDetails();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("Sample Book1                                       | Nagesh          | 2009 \n" +
                "Sample Book2                                       | Naresh          | 2010 \n" +
                "Sample Book3                                       | Ganesh          | 2011 \n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
