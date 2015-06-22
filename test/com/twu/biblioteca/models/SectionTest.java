package com.twu.biblioteca.models;

import com.twu.biblioteca.users.Member;
import com.twu.biblioteca.users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SectionTest {

    private List<LibraryItem> availableBooksList;
    private List<LibraryItem> searchResultsList;
    private Section bookSection;
    private User member;

    @Before
    public void setUp() {
        availableBooksList = new ArrayList<>();
        HashMap<User, List<LibraryItem>> checkedOutBooksList = new HashMap<>();
        member = new Member("123-4567", "password", "Nagesh", "nagesh@gmail.com", "password");
        List<LibraryItem> books = new ArrayList<>();
        books.add(new Book("Sample Book1", "Nagesh", "2009"));
        checkedOutBooksList.put(member, books);
        searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);
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

    @Test
    public void shouldBeAbleToDisplayCheckedOutItemsList() {
        String actualResponse = bookSection.displayCheckedOutItemDetails();

        assertThat(actualResponse, is("| 123-4567 : Nagesh          | => | Sample Book1                                       | Nagesh          | 2009  |\n"));
    }
}
