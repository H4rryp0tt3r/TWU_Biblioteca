package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.RETURN_PROMPT_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_RETURN_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReturnBookActionTest {
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("Sample Book1\n".getBytes());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Library library;
    private IOModule ioModule;

    @Before
    public void setUp() {
        List<Book> availableBooksList = new ArrayList<>();
        List<Book> checkedOutBooksList = new ArrayList<>();
        checkedOutBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        List<Book> searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        ioModule = new IOModule(new Scanner(new BufferedInputStream(inContent)), new PrintStream(outContent));
        library = new Library(availableBooksList, checkedOutBooksList, searchResultsList, ioModule);
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformCheckOutAction() throws IOException {
        ReturnBookAction returnBookAction = new ReturnBookAction(library, ioModule);
        returnBookAction.execute();

        String actualStatusMessage = outContent.toString();

        assertThat(actualStatusMessage, is(RETURN_PROMPT_MESSAGE + SUCCESSFUL_RETURN_MESSAGE + "\n"));
    }

    @After
    public void cleanUp() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }
}
