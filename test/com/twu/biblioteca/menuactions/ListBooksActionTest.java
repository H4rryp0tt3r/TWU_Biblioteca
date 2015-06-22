package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.LibraryItem;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.Member;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListBooksActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Section bookSection;
    private Controller controller;

    @Before
    public void setUp() {
        List<LibraryItem> availableBooksList = new ArrayList<>();
        User member = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        HashMap<User, List<LibraryItem>> checkedOutBooksList = new HashMap<>();
        List<LibraryItem> books = new ArrayList<>();
        books.add(new Book("Sample Book1", "Nagesh", "2009"));
        checkedOutBooksList.put(member, books);
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        IOModule ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);
        controller = new Controller(ioModule);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldBeAbleToPerformListBooksAction() {
        ListBooksAction listBooksAction = new ListBooksAction(bookSection, controller);
        listBooksAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("\n-------------------------------------------------------------------------------\n" +
                "| Sample Book1                                       | Nagesh          | 2009 |\n" +
                "| Sample Book2                                       | Naresh          | 2010 |\n" +
                "| Sample Book3                                       | Ganesh          | 2011 |\n" +
                "-------------------------------------------------------------------------------\n\n"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
