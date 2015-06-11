package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Library;

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