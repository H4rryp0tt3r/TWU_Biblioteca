package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;

public class CheckOutMovieAction implements MenuAction, LoginListener {

    private final Section movieSection;
    private final Controller controller;
    private final String successStatusMessage;
    private final String failedStatusMessage;
    private User user;

    public CheckOutMovieAction(Section movieSection, Controller controller, String successStatusMessage, String failedStatusMessage) {
        this.movieSection = movieSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
    }

    @Override
    public void execute() {
        controller.checkOutAnItem(movieSection, successStatusMessage, failedStatusMessage, user);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
