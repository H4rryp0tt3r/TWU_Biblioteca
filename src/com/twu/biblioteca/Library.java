package com.twu.biblioteca;

import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.COLUMN_SEPARATOR;

public class Library {

    private HashMap<Integer, Book> listOfBooks;

    public Library(HashMap<Integer, Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public void displayBookListWithAllDetails() {
        for (Integer index : listOfBooks.keySet()) {
            System.out.println(index + " " + COLUMN_SEPARATOR + " " + listOfBooks.get(index));
        }
    }

    public Book getBook(int bookNo) {
        return listOfBooks.get(bookNo);
    }
}
