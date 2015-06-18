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

public class ReturnMovieActionTest {
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("Sample Book1\n".getBytes());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Section movieSection;
    private IOModule ioModule;
    private Controller controller;

    @Before
    public void setUp() {
        List<LibraryItem> availableMoviesList = new ArrayList<>();
        List<LibraryItem> checkedOutMoviesList = new ArrayList<>();
        checkedOutMoviesList.add(new Book("Sample Book1", "Nagesh", "2009"));
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableMoviesList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableMoviesList.add(new Book("Sample Book3", "Ganesh", "2011"));
        ioModule = new IOModule(new Scanner(new BufferedInputStream(inContent)), new PrintStream(outContent));
        movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList);
        controller = new Controller(ioModule);
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        ReturnMovieAction returnMovieAction = new ReturnMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE);
        returnMovieAction.execute();

        String actualStatusMessage = outContent.toString();

        assertThat(actualStatusMessage, is(NAME_PROMPT_MESSAGE + SUCCESSFUL_MOVIE_RETURN_MESSAGE + "\n"));
    }

    @After
    public void cleanUp() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }
}
