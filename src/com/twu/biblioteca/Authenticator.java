package com.twu.biblioteca;

import java.util.List;

public class Authenticator {
    private List<User> userDB;

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
