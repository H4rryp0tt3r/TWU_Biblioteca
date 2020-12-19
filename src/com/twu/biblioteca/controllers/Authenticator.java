package com.twu.biblioteca.controllers;

import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.users.User;

import java.util.List;

public class Authenticator {
    private final List<User> userDB;

    public Authenticator(List<User> userDB) {
        this.userDB = userDB;
    }

    public User authenticate(String libraryNumber, String password) {
        for (User user : userDB) {
            if (user.verifyCredentials(libraryNumber, password))
                return user;
        }
        return Guest.create();
    }
}
