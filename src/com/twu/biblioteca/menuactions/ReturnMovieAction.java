package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class ReturnMovieAction implements MenuAction, LoginListener {

    private Section movieSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;
    private User user;

    public ReturnMovieAction(Section movieSection, Controller controller, String successStatusMessage, String failedStatusMessage) {
        this.movieSection = movieSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
    }

    @Override
    public void execute() {
        controller.returnAnItem(movieSection, successStatusMessage, failedStatusMessage);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
