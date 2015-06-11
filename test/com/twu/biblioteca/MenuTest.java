package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.InvalidAction;
import com.twu.biblioteca.menuactions.ListBooksAction;
import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.LIST_BOOKS_OPTION_DESCRPTION;
import static com.twu.biblioteca.BibliotecaAppConstants.QUIT_OPTION_DESCRIPTION;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private HashMap<Integer, String> optionList = new HashMap<>();
    private HashMap<Integer, MenuAction> actionList = new HashMap<>();
    private final HashMap<Integer, Book> listOfBooks = new HashMap<>();
    ;
    private Library library;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        optionList.put(-1, "Invalid Option");
        actionList.put(-1, new InvalidAction());
        optionList.put(1, LIST_BOOKS_OPTION_DESCRPTION);
        actionList.put(1, new ListBooksAction(library));
        optionList.put(2, QUIT_OPTION_DESCRIPTION);
        actionList.put(2, new QuitAction());
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        this.library = new Library(listOfBooks);
    }

    @Test
    public void shouldBeAbleToPrintMenuInRequiredFormat() {
        Menu menu = new Menu(optionList, actionList);

        String actualMenu = menu.toString();

        assertThat(actualMenu, is("1) List Books\n2) Quit\n"));
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

        String actualInvokedClass = menu.chooseOption(3).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.InvalidAction"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
