package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void shouldBeAbleToReturnBookDetails() {
        Book book = new Book("Sample Book", "H4rryp0tt3r", "2009");

        String actualResponse = book.toString();

        assertThat(actualResponse, is("Sample Book                                        | H4rryp0tt3r     | 2009 "));
    }

    @Test
    public void shouldFollowSymmetryProperty() {
        Book firstBook = new Book("Book1", "Suresh", "2020");

        Book secondBook = new Book("Book1", "Suresh", "2020");

        assertThat(firstBook, is(secondBook));
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Book firstBook = new Book("Book1", "Nagesh", "2009");
        Book secondBook = new Book("Book1", "Nagesh", "2009");
        Book thirdBook = new Book("Book1", "Nagesh", "2009");

        assertThat(firstBook, is(secondBook));
        assertThat(secondBook, is(thirdBook));
        assertThat(firstBook, is(thirdBook));
    }

    @Test
    public void shouldBeAbleToCheckWhetherBookNameIsGivenBookNameOrNot() {
        Book book = new Book("Sample Book", "Nagesh", "2015");

        boolean actualResult = book.match("Sample Book");

        assertThat(actualResult, is(true));
    }
}
