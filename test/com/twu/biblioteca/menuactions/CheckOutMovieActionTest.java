package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckOutMovieActionTest {
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("Interstellar\n".getBytes());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Section movieSection;
    private IOModule ioModule;
    private Controller controller;

    @Before
    public void setUp() {
        List<LibraryItem> availableMoviesList = new ArrayList<>();
        List<LibraryItem> checkedOutMoviesList = new ArrayList<>();
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableMoviesList.add(new Movie("Interstellar", "Nolan", "2015", "8.9"));
        availableMoviesList.add(new Movie("Harry Potter", "Nagesh", "2023", "7.9"));
        availableMoviesList.add(new Movie("Minions", "Gru", "2015", "Unrated"));
        ioModule = new IOModule(new Scanner(new BufferedInputStream(inContent)), new PrintStream(outContent));
        movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList, ioModule);
        controller = new Controller(ioModule);
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        CheckOutMovieAction checkOutMovieAction = new CheckOutMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE);
        checkOutMovieAction.execute();

        String actualStatusMessage = outContent.toString();

        assertThat(actualStatusMessage, is(NAME_PROMPT_MESSAGE + SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE + "\n"));
    }

    @After
    public void cleanUp() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }
}
