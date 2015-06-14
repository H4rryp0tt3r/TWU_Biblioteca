package com.twu.biblioteca.menuactions;

// This Class executes the Application Quit Action
public class QuitAction implements MenuAction {
    @Override
    public void execute() {
        System.exit(0);
    }
}
