package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks;

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public void displayBookListWithAllDetails() {
        for (int i = 0; i < listOfBooks.size(); i++) {
            System.out.println(listOfBooks.get(i));
        }
    }
}
