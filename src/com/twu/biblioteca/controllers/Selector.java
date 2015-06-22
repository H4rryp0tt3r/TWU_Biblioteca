package com.twu.biblioteca.controllers;

import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.users.Librarian;
import com.twu.biblioteca.users.Member;

public interface Selector {
    void selectAppropriateMenu(Guest guest);

    void selectAppropriateMenu(Member member);

    void selectAppropriateMenu(Librarian librarian);
}