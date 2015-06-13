package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.CheckOutAction;
import com.twu.biblioteca.menuactions.InvalidAction;
import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
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
            if (actionToBePerformed instanceof CheckOutAction) {
                actionToBePerformed = getCheckOutAction();
            }
            actionToBePerformed.execute();
        }
    }

    private MenuAction getCheckOutAction() {
        ioModule.print(CHECKOUT_PROMPT_MESSAGE);
        int userChoosenBookSno = Integer.parseInt(ioModule.readInput());
        Book bookToCheckOut = library.getBook(userChoosenBookSno);
        MenuAction actionToBePerformed = new CheckOutAction(bookToCheckOut);
        return actionToBePerformed;
    }

    private boolean isQuitAction(MenuAction actionToBePerformed) {
        return actionToBePerformed instanceof QuitAction;
    }
}
