package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToReturnBookDetails() {
        Book book = new Book("Sample Book", "H4rryp0tt3r", "2009");

        String actualResponse = book.toString();

        assertThat(actualResponse, is("Sample Book                                        | H4rryp0tt3r     | 2009 "));
    }

    @Test
    public void shouldFollowSymmetryProperty() {
        Book firstBook = new Book("Book1", "Suresh", "2020");

        Book secondBook = new Book("Book1", "Suresh", "2020");

        assertThat(firstBook, is(secondBook));
    }

    @Test
    public void shouldBeAbleToPrintSuccessCheckOutMessageWhenABookIsCheckedOut() {
        Book book = new Book("Sample Book", "H4rryp0tt3r", "2009");

        String actualStatusMessage = book.checkOut();

        assertThat(actualStatusMessage, is(SUCCESSFUL_CHECKOUT_MESSAGE));
    }

    @Test
    public void shouldBeAbleToReturnCheckOutStatusOfABook() {
        Book book = new Book("Testing","Nagesh","2015");

        Boolean actualStatus = book.getCheckOutStatus();
        
        assertThat(actualStatus, is(false));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
