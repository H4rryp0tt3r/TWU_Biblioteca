package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;

public class ReturnBookAction implements MenuAction, LoginListener {

    private Section bookSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;
    private User user;

    public ReturnBookAction(Section bookSection, Controller controller, String successStatusMessage, String failedStatusMessage) {
        this.bookSection = bookSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
    }

    @Override
    public void execute() {
        controller.returnAnItem(bookSection, successStatusMessage, failedStatusMessage);
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
