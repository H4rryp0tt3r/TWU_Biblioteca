package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;

public class CheckOutBookAction implements MenuAction, LoginListener {

    private Section bookSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;
    private LoginAction loginAction;
    private User user;

    public CheckOutBookAction(Section bookSection, Controller controller, String successStatusMessage, String failedStatusMessage, LoginAction loginActionParam) {
        this.bookSection = bookSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
        this.loginAction = loginActionParam;
        loginAction.addListener(this);
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
