package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class CheckOutMovieAction implements MenuAction, LoginListener {

    private Section movieSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;
    private LoginAction loginAction;
    private User user;

    public CheckOutMovieAction(Section movieSection, Controller controller, String successStatusMessage, String failedStatusMessage, LoginAction loginActionParam) {
        this.movieSection = movieSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
        this.loginAction = loginActionParam;
        loginAction.addListener(this);
    }

    @Override
    public void execute() {
        controller.checkOutAnItem(movieSection, successStatusMessage, failedStatusMessage);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
