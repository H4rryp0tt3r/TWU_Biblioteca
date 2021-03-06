package com.twu.biblioteca.users;

import com.twu.biblioteca.controllers.Selector;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.LIBRARIAN_LOGIN_STATUS_MESSAGE;

public class Librarian extends User {
    public Librarian(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        super(libraryNumber, password, name, emailAddress, phoneNumber);
    }

    @Override
    public String statusMessage() {
        return LIBRARIAN_LOGIN_STATUS_MESSAGE;
    }

    @Override
    public void acceptSelector(Selector selector) {
        selector.selectAppropriateMenu(this);
    }
}