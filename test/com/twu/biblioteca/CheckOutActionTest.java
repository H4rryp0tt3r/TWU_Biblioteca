package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.CheckOutAction;
import com.twu.biblioteca.menuactions.ListBooksAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckOutActionTest {
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
        this.library = new Library(listOfBooks);
    }

    @Test
    public void shouldBeAbleToPerformCheckOutActionWhenBookIsNotCheckedOut() {
        Book book = library.getBook(1);
        CheckOutAction checkOutAction = new CheckOutAction(book);
        checkOutAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(SUCCESSFUL_CHECKOUT_MESSAGE+"\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
