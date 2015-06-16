package com.twu.biblioteca;

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
}
