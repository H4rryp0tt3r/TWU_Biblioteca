package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;

public class CheckOutBookAction implements MenuAction {

    private Section bookSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;

    public CheckOutBookAction(Section bookSection, Controller controller, String successStatusMessage, String failedStatusMessage) {
        this.bookSection = bookSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
    }

    @Override
    public void execute() {
        controller.checkOutAnItem(bookSection, successStatusMessage, failedStatusMessage);
    }
}
