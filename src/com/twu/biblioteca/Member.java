package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaAppConstants.MEMBER_LOGIN_STATUS_MESSAGE;

public class Member extends User {
    public Member(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        super(libraryNumber, password, name, emailAddress, phoneNumber);
    }

    @Override
    public String statusMessage() {
        return MEMBER_LOGIN_STATUS_MESSAGE;
    }

    @Override
    public void acceptSelector(Selector selector) {
        selector.selectAppropriateMenu(this);
    }
}