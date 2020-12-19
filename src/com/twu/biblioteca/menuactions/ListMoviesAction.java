package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.Section;

// This Class executes the List Books Action
public class ListMoviesAction implements MenuAction {

    private final Section movieSection;
    private final Controller controller;

    public ListMoviesAction(Section movieSection, Controller controller) {
        this.movieSection = movieSection;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.listAvailableItems(movieSection);
    }
}