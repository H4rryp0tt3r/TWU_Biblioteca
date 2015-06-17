package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldFollowSymmetryProperty() {
        Movie firstMovie = new Movie("Harry Potter", "Nagesh", "2023", "7.9");

        Movie secondMovie = new Movie("Harry Potter", "Nagesh", "2023", "7.9");

        assertThat(firstMovie, is(secondMovie));
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Movie firstMovie = new Movie("Interstellar", "Nolan", "2015", "8.9");
        Movie secondMovie = new Movie("Interstellar", "Nolan", "2015", "8.9");
        Movie thirdMovie = new Movie("Interstellar", "Nolan", "2015", "8.9");

        assertThat(firstMovie, is(secondMovie));
        assertThat(secondMovie, is(thirdMovie));
        assertThat(firstMovie, is(thirdMovie));
    }

    @Test
    public void shouldBeAbleToReturnMovieDetails() {
        Movie movie = new Movie("Interstellar", "Nolan", "2015", "8.9");

        String actualResponse = movie.toString();

        assertThat(actualResponse, is("Interstellar                             | Nolan                     | 2015 | 8.9  "));
    }

    @Test
    public void shouldBeAbleToCheckWhetherMovieNameIsGivenMovieNameOrNot() {
        Movie movie = new Movie("Interstellar", "Nolan", "2015", "8.9");

        boolean actualResult = movie.match("Interstellar");

        assertThat(actualResult, is(true));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
