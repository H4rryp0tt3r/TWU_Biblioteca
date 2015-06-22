package com.twu.biblioteca.controllers;

import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.users.Librarian;
import com.twu.biblioteca.users.Member;
import com.twu.biblioteca.users.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AuthenticatorTest {

    @Test
    public void shouldBeAbleToReturnUserUponSuccessfullAuthentication() {
        User member = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        User librarian = new Librarian("111-1111", "password", "Librarian", "librarian@librarians.com", "9876543210");
        List<User> userDB = new ArrayList<>();
        userDB.add(member);
        userDB.add(librarian);
        Authenticator authenticator = new Authenticator(userDB);

        User actualUser = authenticator.authenticate("123-4567", "s3cr3t");

        assertThat(actualUser, is(member));
    }

    @Test
    public void shouldBeAbleToReturnGuestUponFailedAuthentication() {
        User guest = Guest.create();
        User member = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        User librarian = new Librarian("111-1111", "password", "Librarian", "librarian@librarians.com", "9876543210");
        List<User> userDB = new ArrayList<>();
        userDB.add(member);
        userDB.add(librarian);
        Authenticator authenticator = new Authenticator(userDB);

        User actualUser = authenticator.authenticate("123-asd", "s3cr3twer");

        assertThat(actualUser, is(guest));
    }
}
