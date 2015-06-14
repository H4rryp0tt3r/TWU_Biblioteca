package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;

import static com.twu.biblioteca.BibliotecaAppConstants.MENU_PROMPT;
import static com.twu.biblioteca.BibliotecaAppConstants.WELCOME_MESSAGE;

// This Class Uses IOModule to Take User Input And then It gets an appropriate action from Menu and then executes it
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
        ioModule.println(WELCOME_MESSAGE);
        MenuAction actionToBePerformed;
        do {
            ioModule.println(menu.toString());
            ioModule.print(MENU_PROMPT);
            int userChoice = Integer.parseInt(ioModule.readInput());
            actionToBePerformed = menu.chooseOption(userChoice);
            actionToBePerformed.execute();
        } while(!isQuitAction(actionToBePerformed));
    }

    private boolean isQuitAction(MenuAction actionToBePerformed) {
        return actionToBePerformed instanceof QuitAction;
    }
}
