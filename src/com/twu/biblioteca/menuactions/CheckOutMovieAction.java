package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;

public class CheckOutMovieAction implements MenuAction {

    private Section movieSection;
    private Controller controller;
    private String successStatusMessage;
    private String failedStatusMessage;

    public CheckOutMovieAction(Section movieSection, Controller controller, String successStatusMessage, String failedStatusMessage) {
        this.movieSection = movieSection;
        this.controller = controller;
        this.successStatusMessage = successStatusMessage;
        this.failedStatusMessage = failedStatusMessage;
    }

    @Override
    public void execute() {
        controller.checkOutAnItem(movieSection, successStatusMessage, failedStatusMessage);
    }
}
