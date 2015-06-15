package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BibliotecaAppConstants;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.menuactions.InvalidAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        this.library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
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
