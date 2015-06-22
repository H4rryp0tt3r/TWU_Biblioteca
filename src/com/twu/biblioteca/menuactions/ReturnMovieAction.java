package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;

public class ReturnMovieAction implements MenuAction, LoginListener {

    private Section movieSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;
    private LoginAction loginAction;
    private User user;

    public ReturnMovieAction(Section movieSection, Controller controller, String successStatusMessage, String failedStatusMessage, LoginAction loginActionParam) {
        this.movieSection = movieSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
        this.loginAction = loginActionParam;
        loginAction.addListener(this);
    }

    @Override
    public void execute() {
        controller.returnAnItem(movieSection, successStatusMessage, failedStatusMessage, user);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
