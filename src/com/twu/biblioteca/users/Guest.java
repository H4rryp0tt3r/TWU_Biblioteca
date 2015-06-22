package com.twu.biblioteca.users;

import com.twu.biblioteca.controllers.Selector;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.INVALID_CREDENTIALS_MESSAGE;

public class Guest extends User {
    public Guest() {
        super("", "", "", "", "");
    }

    public static Guest create() {
        return new Guest();
    }

    @Override
    public String statusMessage() {
        return INVALID_CREDENTIALS_MESSAGE;
    }

    @Override
    public void acceptSelector(Selector selector) {
        selector.selectAppropriateMenu(this);
    }
}