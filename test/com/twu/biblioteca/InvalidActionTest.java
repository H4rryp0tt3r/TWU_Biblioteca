package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.InvalidAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InvalidActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Library library;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.add(new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.add(new Book("Sample Book3", "Ganesh", "2011"));
        this.library = new Library(listOfBooks);
    }

    @Test
    public void shouldBeAbleToPrintInvalidMessageWhenUserProvidesAnUnkonownOption() {
        InvalidAction invalidAction = new InvalidAction();
        invalidAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(BibliotecaAppConstants.INVALID_SELECTION_MESSAGE + "\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}