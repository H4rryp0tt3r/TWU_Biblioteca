package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;

// This Class executes the List Books Action
public class ListMoviesAction implements MenuAction {

    private Section movieSection;
    private Controller controller;

    public ListMoviesAction(Section movieSection, Controller controller) {
        this.movieSection = movieSection;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.listAvailableItems(movieSection);
    }
}