package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_CREDENTIALS_MESSAGE;

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