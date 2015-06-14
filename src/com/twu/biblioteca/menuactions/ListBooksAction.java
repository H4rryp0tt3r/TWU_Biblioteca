package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Library;

// This Class executes the List Books Action
public class ListBooksAction implements MenuAction {

    private Library library;

    public ListBooksAction(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.displayBookListWithAllDetails();
    }
}