package com.twu.biblioteca;

public class QuitAction implements MenuAction {
    @Override
    public void execute() {
        System.exit(0);
    }
}
