package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private HashMap<Integer, String> optionList = new HashMap<>();
    private HashMap<Integer, MenuAction> actionList = new HashMap<>();
    private Menu menu;

    @Before
    public void setUp() {
        List<Book> availableBooksList = new ArrayList<>();
        List<Book> checkedOutBooksList = new ArrayList<>();
        List<Book> searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        IOModule ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        Library library = new Library(availableBooksList, checkedOutBooksList, searchResultsList, ioModule);
        menu = new Menu(optionList, actionList);
        menu.addOption(-1, null, new InvalidAction());
        menu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(library));
        menu.addOption(2, CHECKOUT_OPTION_DESCRIPTION, new CheckOutAction(library, ioModule));
        menu.addOption(3, QUIT_OPTION_DESCRIPTION, new QuitAction());
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPrintMenuInRequiredFormat() {
        String actualMenu = menu.toString();

        assertThat(actualMenu, is("1) List Books\n2) Checkout A Book\n3) Quit\n"));
    }

    @Test
    public void shouldBeAbleToPerformTheCorrectMenuActionOnUserChoice() {
        String actualInvokedClass = menu.chooseOption(1).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.ListBooksAction"));
    }

    @Test
    public void shouldBeAbleToReturnInvalidActionWhenUserProvidesAnInvalidOption() {
        String actualInvokedClass = menu.chooseOption(7).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.InvalidAction"));
    }

    @Test
    public void shouldBeAbleToAddAnOptionToExistingMenu() {
        menu.addOption(6, QUIT_OPTION_DESCRIPTION, new QuitAction());

        String actualInvokedClass = menu.chooseOption(6).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.QuitAction"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
