package com.twu.biblioteca;

import java.util.HashMap;

public class CheckOutHistory {
    HashMap<User, LibraryItem> checkedOutItemsList;

    public CheckOutHistory(HashMap<User, LibraryItem> checkedOutItemsList) {
        this.checkedOutItemsList = checkedOutItemsList;
    }

    public void addItemToHistory(LibraryItem libraryItem, User user) {
        checkedOutItemsList.put(user, libraryItem);
    }
}
