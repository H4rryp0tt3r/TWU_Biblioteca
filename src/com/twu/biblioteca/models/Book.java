package com.twu.biblioteca.models;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.BOOK_DETAILS_FORMAT_PATTERN;

// This Class Store Book data and Has a formatter to Print itself
public class Book implements LibraryItem {
    private final String name;
    private final String author;
    private final String yearOfPublictaion;

    public Book(String name, String author, String yearOfPublictaion) {
        this.name = name;
        this.author = author;
        this.yearOfPublictaion = yearOfPublictaion;
    }

    @Override
    public String toString() {
        return String.format(BOOK_DETAILS_FORMAT_PATTERN, name, author, yearOfPublictaion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name.equals(book.name);

    }

    public boolean match(String givenBookName) {
        return name.equals(givenBookName);
    }
}
