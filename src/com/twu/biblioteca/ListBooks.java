package com.twu.biblioteca;

public class ListBooks implements MenuAction {

    private Library library;

    public ListBooks(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.displayBookListWithAllDetails();
    }
}