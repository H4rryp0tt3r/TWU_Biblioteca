package com.twu.biblioteca;

public interface Selector {
    void selectAppropriateMenu(Guest guest);

    void selectAppropriateMenu(Member member);

    void selectAppropriateMenu(Librarian librarian);
}