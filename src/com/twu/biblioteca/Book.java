package com.twu.biblioteca;

public class Book {
    private String name, author, yearOfPublictaion;

    public Book(String name, String author, String yearOfPublictaion) {
        this.name = name;
        this.author = author;
        this.yearOfPublictaion = yearOfPublictaion;
    }

    @Override
    public String toString() {
        return String.format(BibliotecaAppConstants.BOOK_DETAILS_FORMAT_PATTERN, name, author, yearOfPublictaion);
    }
}
