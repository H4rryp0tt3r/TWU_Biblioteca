package com.twu.biblioteca;

public class Quit implements MenuAction {
    @Override
    public void execute() {
        System.exit(0);
    }
}
