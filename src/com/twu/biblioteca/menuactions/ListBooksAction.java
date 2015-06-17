package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;

// This Class executes the List Books Action
public class ListBooksAction implements MenuAction {

    private Section bookSection;
    private Controller controller;

    public ListBooksAction(Section bookSection, Controller controller) {
        this.bookSection = bookSection;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.listAvailableItems(bookSection);
    }
}