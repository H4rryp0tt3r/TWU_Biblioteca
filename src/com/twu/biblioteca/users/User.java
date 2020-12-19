package com.twu.biblioteca.users;

import com.twu.biblioteca.controllers.Selector;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.USER_BASIC_DETAILS_FORMAT_PATTERN;
import static com.twu.biblioteca.constants.BibliotecaAppConstants.USER_DETAILS_FORMAT_PATTERN;

public abstract class User {
    private final String libraryNumber;
    private final String password;
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;

    public User(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public boolean verifyCredentials(String libraryNumber, String password) {
        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!libraryNumber.equals(user.libraryNumber)) return false;
        return password.equals(user.password);

    }

    @Override
    public String toString() {
        return String.format(USER_DETAILS_FORMAT_PATTERN, libraryNumber, name, emailAddress, phoneNumber);
    }

    public String getUserBasicDetails() {
        return String.format(USER_BASIC_DETAILS_FORMAT_PATTERN, libraryNumber, name);
    }

    public abstract String statusMessage();

    public abstract void acceptSelector(Selector selector);
}