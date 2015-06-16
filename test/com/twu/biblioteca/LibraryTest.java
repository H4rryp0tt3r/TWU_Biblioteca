package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private List<Book> availableBooksList;
    private List<Book> checkedOutBooksList;
    private List<Book> searchResultsList;
    private IOModule ioModule;

    @Before
    public void setUp() {
        availableBooksList = new ArrayList<>();
        checkedOutBooksList = new ArrayList<>();
        searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToDisplayBooksByDetails() {
        Library library = new Library(availableBooksList, checkedOutBooksList, searchResultsList, ioModule);
        library.displayAvailableBookListWithAllDetails();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("Sample Book1                                       | Nagesh          | 2009 \n" +
                "Sample Book2                                       | Naresh          | 2010 \n" +
                "Sample Book3                                       | Ganesh          | 2011 \n"));
    }

    @Test
    public void shouldBeAbleToSearchAndReturnFoundBooks() {
        Library library = new Library(availableBooksList, checkedOutBooksList, searchResultsList, ioModule);
        List<Book> expectedFoundBooksList = new ArrayList<>();
        expectedFoundBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));

        library.searchBooksByName("Sample Book1", availableBooksList);

        assertThat(searchResultsList, is(expectedFoundBooksList));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
