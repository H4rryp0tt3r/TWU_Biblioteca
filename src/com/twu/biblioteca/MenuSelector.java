package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;

public class MenuSelector implements Selector {
    private Menu guestMenu;
    private Menu memberMenu;
    private Menu librarianMenu;

    public MenuSelector(Menu guestMenu, Menu memberMenu, Menu librarianMenu) {
        this.guestMenu = guestMenu;
        this.memberMenu = memberMenu;
        this.librarianMenu = librarianMenu;
    }

    @Override
    public void selectAppropriateMenu(Guest guest) {
        MenuAction actionToBePerformed;
        do {
            actionToBePerformed = guestMenu.chooseOption();
            actionToBePerformed.execute();
        }
        while (!isQuitAction(actionToBePerformed));
    }

    @Override
    public void selectAppropriateMenu(Member member) {
        MenuAction actionToBePerformed;
        do {
            actionToBePerformed = memberMenu.chooseOption();
            actionToBePerformed.execute();
        }
        while (!isQuitAction(actionToBePerformed));
    }

    @Override
    public void selectAppropriateMenu(Librarian librarian) {
        MenuAction actionToBePerformed;
        do {
            actionToBePerformed = librarianMenu.chooseOption();
            actionToBePerformed.execute();
        }
        while (!isQuitAction(actionToBePerformed));
    }

    private boolean isQuitAction(MenuAction actionToBePerformed) {
        return actionToBePerformed instanceof QuitAction;
    }
}
