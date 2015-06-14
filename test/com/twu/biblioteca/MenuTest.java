package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final HashMap<Integer, Book> listOfBooks = new HashMap<>();
    @Mock
    IOModule mockIOModule;
    private HashMap<Integer, String> optionList = new HashMap<>();
    private HashMap<Integer, MenuAction> actionList = new HashMap<>();
    private Library library;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        optionList.put(-1, null);
        actionList.put(-1, new InvalidAction());
        optionList.put(1, LIST_BOOKS_OPTION_DESCRPTION);
        actionList.put(1, new ListBooksAction(library));
        optionList.put(2, CHECKOUT_OPTION_DESCRIPTION);
        actionList.put(2, new CheckOutBookAction(library, mockIOModule));
        optionList.put(3, RETURN_BOOK_OPTION_DESCRIPTION);
        actionList.put(3, new ReturnBookAction(library, mockIOModule));
        optionList.put(4, QUIT_OPTION_DESCRIPTION);
        actionList.put(4, new QuitAction());
        actionList.put(3, new QuitAction());
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        this.library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
    }

    @Test
    public void shouldBeAbleToPrintMenuInRequiredFormat() {
        Menu menu = new Menu(optionList, actionList);

        String actualMenu = menu.toString();

        assertThat(actualMenu, is("1) List Books\n2) Checkout A Book\n3) Return A Book\n4) Quit\n"));
    }

    @Test
    public void shouldBeAbleToPerformTheCorrectMenuActionOnUserChoice() {
        Menu menu = new Menu(optionList, actionList);

        String actualInvokedClass = menu.chooseOption(1).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.ListBooksAction"));
    }

    @Test
    public void shouldBeAbleToReturnInvalidActionWhenUserProvidesAnInvalidOption() {
        Menu menu = new Menu(optionList, actionList);

        String actualInvokedClass = menu.chooseOption(5).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.InvalidAction"));
    }

    @Test
    public void shouldBeAbleToAddAnOptionToExistingMenu() {
        Menu menu = new Menu(optionList, actionList);
        menu.addOption(6, QUIT_OPTION_DESCRIPTION, new QuitAction());

        String actualInvokedClass = menu.chooseOption(6).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.QuitAction"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
