package com.twu.biblioteca;

import java.util.List;

// This class will holds list of books & a checkout Record. And has methods to Checkout & Return a Book.
public class Library {

    private List<Book> availableBooksList;
    private List<Book> checkedOutBooksList;
    private IOModule ioModule;

    public Library(List<Book> availableBooksList, List<Book> checkedOutBooksList, IOModule ioModule) {
        this.availableBooksList = availableBooksList;
        this.checkedOutBooksList = checkedOutBooksList;
        this.ioModule = ioModule;
    }

    public void displayBookListWithAllDetails() {
        for (Book book : availableBooksList) {
            ioModule.println(book.toString());
        }
    }
}
