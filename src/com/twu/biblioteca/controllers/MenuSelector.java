package com.twu.biblioteca.controllers;

import com.twu.biblioteca.menuactions.LogOutAction;
import com.twu.biblioteca.menuactions.LoginAction;
import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.users.Librarian;
import com.twu.biblioteca.users.Member;

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
        while (!isLoginAction(actionToBePerformed));
    }

    @Override
    public void selectAppropriateMenu(Member member) {
        MenuAction actionToBePerformed;
        do {
            actionToBePerformed = memberMenu.chooseOption();
            actionToBePerformed.execute();
        }
        while (!isLogOutAction(actionToBePerformed));
    }

    @Override
    public void selectAppropriateMenu(Librarian librarian) {
        MenuAction actionToBePerformed;
        do {
            actionToBePerformed = librarianMenu.chooseOption();
            actionToBePerformed.execute();
        }
        while (!isLogOutAction(actionToBePerformed));
    }

    private boolean isLogOutAction(MenuAction actionToBePerformed) {
        return actionToBePerformed instanceof LogOutAction;
    }

    private boolean isLoginAction(MenuAction actionToBePerformed) {
        return actionToBePerformed instanceof LoginAction;
    }
}
