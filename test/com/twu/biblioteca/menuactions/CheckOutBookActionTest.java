package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.menuactions.CheckOutBookAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.FAILED_CHECKOUT_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_CHECKOUT_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Mock
    IOModule mockIOModule;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPrintSuccessCheckoutMessageIfBookIsNotCheckedOut() throws IOException {
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(library, mockIOModule);
        when(mockIOModule.readInput()).thenReturn("1");
        checkOutBookAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(SUCCESSFUL_CHECKOUT_MESSAGE + "\n"));
    }

    @Test
    public void shouldBeAbleToPrintAnErrorMessageWhenAUserTriesToCheckoutABookThatIsAlreadyCheckedOut() throws IOException {
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        checkedOutBooksSerialNumbers.add(1);
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(library, mockIOModule);
        when(mockIOModule.readInput()).thenReturn("1");
        checkOutBookAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(FAILED_CHECKOUT_MESSAGE + "\n"));
    }

    @Test
    public void shouldBeAbleToPrintAnErrorMessageIfUserEntersAnUnknownBookSno() throws IOException {
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(library, mockIOModule);
        when(mockIOModule.readInput()).thenReturn("4");
        checkOutBookAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(FAILED_CHECKOUT_MESSAGE + "\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
