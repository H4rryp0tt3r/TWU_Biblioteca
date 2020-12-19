package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.Section;

// This Class executes the List Books Action
public class ListBooksAction implements MenuAction {

    private final Section bookSection;
    private final Controller controller;

    public ListBooksAction(Section bookSection, Controller controller) {
        this.bookSection = bookSection;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.listAvailableItems(bookSection);
    }
}