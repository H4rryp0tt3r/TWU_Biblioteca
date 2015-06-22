package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.LibraryItem;
import com.twu.biblioteca.models.Movie;
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

public class ListMoviesActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Section movieSection;
    private Controller controller;

    @Before
    public void setUp() {
        List<LibraryItem> availableMoviesList = new ArrayList<>();
        User member = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        HashMap<User, List<LibraryItem>> checkedOutMoviesList = new HashMap<>();
        List<LibraryItem> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Nagesh", "1994", "Unrated"));
        checkedOutMoviesList.put(member, movies);
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableMoviesList.add(new Movie("Interstellar", "Nolan", "2015", "8.9"));
        availableMoviesList.add(new Movie("Harry Potter", "Nagesh", "2023", "7.9"));
        availableMoviesList.add(new Movie("Minions", "Gru", "2015", "Unrated"));
        IOModule ioModule = new IOModule(new Scanner(new BufferedInputStream(System.in)), new PrintStream(outContent));
        movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList);
        controller = new Controller(ioModule);
        System.setOut(new PrintStream(outContent));
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
    }
}
