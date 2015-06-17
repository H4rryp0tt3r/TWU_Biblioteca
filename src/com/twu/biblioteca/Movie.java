package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.MOVIE_DETAILS_FORMAT_PATTERN;

// This Class Store Movie data and Has a formatter to Print itself
public class Movie {
    private String name, director, year;
    private String rating;

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

        if (!name.equals(movie.name)) return false;
        if (!director.equals(movie.director)) return false;
        if (!year.equals(movie.year)) return false;
        return rating.equals(movie.rating);

    }

    @Override
    public String toString() {
        return String.format(MOVIE_DETAILS_FORMAT_PATTERN, name, director, year, rating);
    }

    public boolean match(String movieName) {
        return name.equals(movieName);
    }
}
