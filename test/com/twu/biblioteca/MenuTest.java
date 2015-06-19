package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Mock
    IOModule mockIOModule;
    private HashMap<Integer, String> optionList = new HashMap<>();
    private HashMap<Integer, MenuAction> actionList = new HashMap<>();
    private Menu menu;
    private IOModule ioModule;
    private Controller controller;

    @Before
    public void setUp() {
        ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));

        List<LibraryItem> availableBooksList = new ArrayList<>();
        List<LibraryItem> checkedOutBooksList = new ArrayList<>();
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        Section bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);

        List<LibraryItem> availableMoviesList = new ArrayList<>();
        availableMoviesList.add(new Movie("H4rryp0tt3r", "Nagesh", "2030", "7.9"));
        availableMoviesList.add(new Movie("Interstellar", "Nolan", "2015", "8.9"));
        availableMoviesList.add(new Movie("Super Man", "Morgan", "1994", "Unrated"));
        List<LibraryItem> checkedOutMoviesList = new ArrayList<>();
        Section movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList);

        controller = new Controller(ioModule);
        menu = new Menu(optionList, actionList, mockIOModule);
        menu.addOption(-1, null, new InvalidAction());
        menu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(bookSection, controller));
        menu.addOption(2, CHECKOUT_BOOK_OPTION_DESCRIPTION, new CheckOutBookAction(bookSection, controller, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE));
        menu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, new ReturnBookAction(bookSection, controller, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE));
        menu.addOption(4, LIST_MOVIES_OPTION_DESCRIPTION, new ListMoviesAction(movieSection, controller));
        menu.addOption(5, CHECKOUT_MOVIE_OPTION_DESCRIPTION, new CheckOutMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE));
        menu.addOption(6, RETURN_BOOK_OPTION_DESCRIPTION, new ReturnMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE));
        menu.addOption(7, QUIT_OPTION_DESCRIPTION, new QuitAction());
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPrintMenuInRequiredFormat() {
        String actualMenu = menu.toString();

        assertThat(actualMenu, is("1) List Books\n2) Checkout A Book\n3) Return A Book\n4) List Movies\n" +
                "5) Checkout A Movie\n6) Return A Book\n7) Quit\n"));
    }

    @Test
    public void shouldBeAbleToPerformTheCorrectMenuActionOnUserChoice() {
        when(mockIOModule.readInput()).thenReturn("1");
        String actualInvokedClass = menu.chooseOption().getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.ListBooksAction"));
    }

    @Test
    public void shouldBeAbleToReturnInvalidActionWhenUserProvidesAnInvalidOption() {
        when(mockIOModule.readInput()).thenReturn("12");
        String actualInvokedClass = menu.chooseOption().getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.InvalidAction"));
    }

    @Test
    public void shouldBeAbleToAddAnOptionToExistingMenu() {
        when(mockIOModule.readInput()).thenReturn("123");
        menu.addOption(123, QUIT_OPTION_DESCRIPTION, new QuitAction());

        String actualInvokedClass = menu.chooseOption().getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.menuactions.QuitAction"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
