package com.twu.biblioteca.menuactions;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_SELECTION_MESSAGE;

// This Class executes when User Enters an Invalid Option
public class InvalidAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println(INVALID_SELECTION_MESSAGE);
    }
}