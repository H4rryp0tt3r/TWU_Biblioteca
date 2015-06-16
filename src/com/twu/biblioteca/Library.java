package com.twu.biblioteca;

import java.util.List;

// This class will holds list of books & a checkout Record. And has methods to Checkout & Return a Book.
public class Library {

    private List<Book> availableBooksList;
    private List<Book> checkedOutBooksList;
    private List<Book> searchResultsList;
    private IOModule ioModule;

    public Library(List<Book> availableBooksList, List<Book> checkedOutBooksList, List<Book> searchResultsList, IOModule ioModule) {
        this.availableBooksList = availableBooksList;
        this.checkedOutBooksList = checkedOutBooksList;
        this.searchResultsList = searchResultsList;
        this.ioModule = ioModule;
    }

    public void displayAvailableBookListWithAllDetails() {
        for (Book book : availableBooksList) {
            ioModule.println(book.toString());
        }
    }

    public List<Book> searchBooksByName(String bookName, List<Book> booksList) {
        searchResultsList.clear();
        for (Book book : booksList) {
            if (book.match(bookName))
                searchResultsList.add(book);
        }
        return searchResultsList;
    }
}
