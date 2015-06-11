package com.twu.biblioteca.menuactions;

public class QuitAction implements MenuAction {
    @Override
    public void execute() {
        System.exit(0);
    }
}
