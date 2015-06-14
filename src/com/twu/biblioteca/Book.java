package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.BOOK_DETAILS_FORMAT_PATTERN;

// This Class Store Book data and Has a formatter to Print itself
public class Book {
    private String name, author, yearOfPublictaion;

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

        if (!name.equals(book.name)) return false;
        if (!author.equals(book.author)) return false;
        return yearOfPublictaion.equals(book.yearOfPublictaion);

    }
}
