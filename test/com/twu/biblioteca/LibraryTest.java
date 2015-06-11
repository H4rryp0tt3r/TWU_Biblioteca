package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final HashMap<Integer, Book> listOfBooks = new HashMap<>();
    ;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
    }

    @Test
    public void shouldBeAbleToDisplayBooksByDetails() {
        Library library = new Library(listOfBooks);
        library.displayBookListWithAllDetails();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("1 | Sample Book1                                       | Nagesh          | 2009 \n" +
                "2 | Sample Book2                                       | Naresh          | 2010 \n" +
                "3 | Sample Book3                                       | Ganesh          | 2011 \n"));
    }

    @Test
    public void shouldBeAbleToFindABookInLibrary() {
        Library library = new Library(listOfBooks);
        Book actualBook = library.getBook(1);

        assertThat(actualBook, is(new Book("Sample Book1", "Nagesh", "2009")));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
