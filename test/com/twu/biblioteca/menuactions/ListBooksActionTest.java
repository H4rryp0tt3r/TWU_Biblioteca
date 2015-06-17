package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.*;
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

public class ListBooksActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Section bookSection;
    private Controller controller;

    @Before
    public void setUp() {
        List<LibraryItem> availableBooksList = new ArrayList<>();
        List<LibraryItem> checkedOutBooksList = new ArrayList<>();
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        IOModule ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList, ioModule);
        controller = new Controller(ioModule);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformListBooksAction() {
        ListBooksAction listBooksAction = new ListBooksAction(bookSection, controller);
        listBooksAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("Sample Book1                                       | Nagesh          | 2009 \n" +
                "Sample Book2                                       | Naresh          | 2010 \n" +
                "Sample Book3                                       | Ganesh          | 2011 \n\n"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
