package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTest {

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
}
