package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.*;

public class Book {
    private String name, author, yearOfPublictaion;
    private boolean isCheckedOut;

    public Book(String name, String author, String yearOfPublictaion) {
        this.name = name;
        this.author = author;
        this.yearOfPublictaion = yearOfPublictaion;
        this.isCheckedOut = false;
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

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + yearOfPublictaion.hashCode();
        return result;
    }

    public boolean getCheckOutStatus() {
        return isCheckedOut;
    }

    public String checkOut() {
        if (isCheckedOut)
            return FAILED_CHECKOUT_MESSAGE;
        isCheckedOut = true;
        return SUCCESSFUL_CHECKOUT_MESSAGE;
    }
}
