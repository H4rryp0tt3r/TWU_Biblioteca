package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARIAN_LOGIN_STATUS_MESSAGE;

public class Librarian extends User {
    public Librarian(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        super(libraryNumber, password, name, emailAddress, phoneNumber);
    }

    @Override
    public String statusMessage() {
        return LIBRARIAN_LOGIN_STATUS_MESSAGE;
    }
}