package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListBooksActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private List<Book> availableBooksList;
    private List<Book> checkedOutBooksList;
    private Library library;
    private IOModule ioModule;

    @Before
    public void setUp() {
        availableBooksList = new ArrayList<>();
        checkedOutBooksList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        ioModule = new IOModule(new Scanner(System.in), new PrintStream(outContent));
        library = new Library(availableBooksList, checkedOutBooksList, ioModule);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformListBooksAction() {
        ListBooksAction listBooksAction = new ListBooksAction(library);
        listBooksAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("Sample Book1                                       | Nagesh          | 2009 \n" +
                "Sample Book2                                       | Naresh          | 2010 \n" +
                "Sample Book3                                       | Ganesh          | 2011 \n"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
