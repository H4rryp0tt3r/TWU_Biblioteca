package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;

import static com.twu.biblioteca.BibliotecaAppConstants.WELCOME_MESSAGE;

public class App {
    private Library library;
    private IOModule ioModule;
    private Menu menu;

    public App(Library library, IOModule ioModule, Menu menu) {
        this.library = library;
        this.ioModule = ioModule;
        this.menu = menu;
    }

    public void start() {
        ioModule.print(WELCOME_MESSAGE);
        MenuAction actionToBePerformed = null;
        while (!isQuitAction(actionToBePerformed)) {
            ioModule.print(menu.toString());
            int userChoice = Integer.parseInt(ioModule.readInput());
            actionToBePerformed = menu.chooseOption(userChoice);
            actionToBePerformed.execute();
        }
    }

    private boolean isQuitAction(MenuAction actionToBePerformed) {
        return actionToBePerformed instanceof QuitAction;
    }
}
