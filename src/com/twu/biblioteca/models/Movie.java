package com.twu.biblioteca.models;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.MOVIE_DETAILS_FORMAT_PATTERN;

// This Class Store Movie data and Has a formatter to Print itself
public class Movie implements LibraryItem {
    private final String name;
    private final String director;
    private final String year;
    private final String rating;

    public Movie(String name, String director, String year, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return name.equals(movie.name);

    }

    @Override
    public String toString() {
        return String.format(MOVIE_DETAILS_FORMAT_PATTERN, name, director, year, rating);
    }

    public boolean match(String movieName) {
        return name.equals(movieName);
    }
}
