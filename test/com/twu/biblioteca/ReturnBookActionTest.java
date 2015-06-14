package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.ReturnBookAction;
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

import static com.twu.biblioteca.BibliotecaAppConstants.FAILED_RETURN_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_RETURN_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
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
    public void shouldBeAbleToPrintSuccessReturnMessageIfUserEntersASnoOfCheckedOutBook() throws IOException {
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        checkedOutBooksSerialNumbers.add(1);
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        ReturnBookAction returnBookAction = new ReturnBookAction(library, mockIOModule);
        when(mockIOModule.readInput()).thenReturn("1");
        returnBookAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(SUCCESSFUL_RETURN_MESSAGE + "\n"));
    }

    @Test
    public void shouldBeAbleToPrintAnErrorMessageWhenAUserTriesToReturnABookThatIsNotYetCheckedOut() throws IOException {
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        ReturnBookAction returnBookAction = new ReturnBookAction(library, mockIOModule);
        when(mockIOModule.readInput()).thenReturn("1");
        returnBookAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(FAILED_RETURN_MESSAGE + "\n"));
    }

    @Test
    public void shouldBeAbleToPrintAnErrorMessageIfUserEntersAnUnknownBookSno() throws IOException {
        HashMap<Integer, Book> listOfBooks = new HashMap<>();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        ReturnBookAction returnBookAction = new ReturnBookAction(library, mockIOModule);
        when(mockIOModule.readInput()).thenReturn("4");
        returnBookAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(FAILED_RETURN_MESSAGE + "\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
