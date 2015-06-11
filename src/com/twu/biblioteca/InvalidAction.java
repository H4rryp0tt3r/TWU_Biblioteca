package com.twu.biblioteca;

public class InvalidAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println(BibliotecaAppConstants.INVALID_SELECTION_MESSAGE);
    }
}