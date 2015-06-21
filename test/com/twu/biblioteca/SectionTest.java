package com.twu.biblioteca;

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

public class SectionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private List<LibraryItem> availableBooksList;
    private HashMap<User, List<LibraryItem>> checkedOutBooksList;
    private List<LibraryItem> searchResultsList;
    private IOModule ioModule;
    private Controller controller;
    private Section bookSection;
    private User member;

    @Before
    public void setUp() {
        availableBooksList = new ArrayList<>();
        checkedOutBooksList = new HashMap<>();
        member = new Member("123-4567", "password", "Nagesh", "nagesh@gmail.com", "password");
        List<LibraryItem> books = new ArrayList<>();
        books.add(new Book("Sample Book1", "Nagesh", "2009"));
        checkedOutBooksList.put(member, books);
        searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        controller = new Controller(ioModule);
        bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToDisplayBooksByDetails() {
        String actualResponse = bookSection.displayAvailableItemsWithAllDetails();

        assertThat(actualResponse, is("Sample Book1                                       | Nagesh          | 2009 \n" +
                "Sample Book2                                       | Naresh          | 2010 \n" +
                "Sample Book3                                       | Ganesh          | 2011 \n"));
    }

    @Test
    public void shouldBeAbleToSearchAndReturnFoundBooks() {
        List<LibraryItem> expectedFoundBooksList = new ArrayList<>();
        expectedFoundBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));

        bookSection.searchItemsByName("Sample Book1", availableBooksList);

        assertThat(searchResultsList, is(expectedFoundBooksList));
    }

    @Test
    public void shouldBeAbleToReturnTrueUponASuccessfulCheckOut() {
        Boolean actualResult = bookSection.checkOut("Sample Book1", member);

        assertThat(actualResult, is(true));
    }

    @Test
    public void shouldBeAbleToReturnFalseUponAFailedCheckOut() {
        boolean actualResult = bookSection.checkOut("Sample Book0", member);

        assertThat(actualResult, is(false));
    }

    @Test
    public void shouldBeAbleToReturnFalseWhenUserTriesToCheckOutABookThatIsAlreadyCheckedOut() {
        bookSection.checkOut("Sample Book1", member);

        boolean actualResult = bookSection.checkOut("Sample Book1", member);

        assertThat(actualResult, is(false));
    }

    @Test
    public void shouldBeAbleToReturnTrueUponASuccessfulReturn() {
        bookSection.checkOut("Sample Book1", member);

        boolean actualStatusMessage = bookSection.returnItem("Sample Book1", member);

        assertThat(actualStatusMessage, is(true));
    }

    @Test
    public void shouldBeAbleToReturnFalseUponAFailedReturn() {
        boolean actualResult = bookSection.returnItem("Sample Book0", member);

        assertThat(actualResult, is(false));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
