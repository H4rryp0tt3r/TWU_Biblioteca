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

public class ListMoviesActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Section movieSection;
    private Controller controller;

    @Before
    public void setUp() {
        List<LibraryItem> availableMoviesList = new ArrayList<>();
        List<LibraryItem> checkedOutMoviesList = new ArrayList<>();
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableMoviesList.add(new Movie("Interstellar", "Nolan", "2015", "8.9"));
        availableMoviesList.add(new Movie("Harry Potter", "Nagesh", "2023", "7.9"));
        availableMoviesList.add(new Movie("Minions", "Gru", "2015", "Unrated"));
        IOModule ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList);
        controller = new Controller(ioModule);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformListBooksAction() {
        ListMoviesAction listMoviesAction = new ListMoviesAction(movieSection, controller);
        listMoviesAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("Interstellar                             | Nolan                     | 2015 | 8.9  \n" +
                "Harry Potter                             | Nagesh                    | 2023 | 7.9  \n" +
                "Minions                                  | Gru                       | 2015 | Unrated\n\n"));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
