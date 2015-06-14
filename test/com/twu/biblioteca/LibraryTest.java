package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.FAILED_CHECKOUT_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_CHECKOUT_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final HashMap<Integer, Book> listOfBooks = new HashMap<>();
    private ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();

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
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        library.displayBookListWithAllDetails();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("1 | Sample Book1                                       | Nagesh          | 2009 \n" +
                "2 | Sample Book2                                       | Naresh          | 2010 \n" +
                "3 | Sample Book3                                       | Ganesh          | 2011 \n\n"));
    }

    @Test
    public void shouldBeAbleToPrintSuccessCheckOutMessageWhenABookIsCheckedOut() {
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);

        String actualStatusMessage = library.checkOutABook(1);

        assertThat(actualStatusMessage, is(SUCCESSFUL_CHECKOUT_MESSAGE));
    }

    @Test
    public void shouldBeAbleToPrintFailedCheckOutMessageWhenUserTriesToCheckoutAAlreadyCheckedOutBook() {
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        library.checkOutABook(1);

        String actualStatusMessage = library.checkOutABook(1);

        assertThat(actualStatusMessage, is(FAILED_CHECKOUT_MESSAGE));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
