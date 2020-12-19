package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;

public class CheckOutBookAction implements MenuAction, LoginListener {

    private final Section bookSection;
    private final Controller controller;
    private final String successStatusMessage;
    private final String failedStatusMessage;
    private User user;

    public CheckOutBookAction(Section bookSection, Controller controller, String successStatusMessage, String failedStatusMessage) {
        this.bookSection = bookSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
    }

    @Override
    public void execute() {
        controller.checkOutAnItem(bookSection, successStatusMessage, failedStatusMessage, user);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
