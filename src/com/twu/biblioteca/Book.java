package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.*;

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
}
