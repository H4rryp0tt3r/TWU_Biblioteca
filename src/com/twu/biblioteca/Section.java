package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// This class will holds list of books & a checkout Record. And has methods to Checkout & Return a Book.
public class Section {

    private List<LibraryItem> availableItemsList;
    private HashMap<User, List<LibraryItem>> checkedOutItemsList;
    private List<LibraryItem> searchResultsList;

    public Section(List<LibraryItem> availableItemsList, HashMap<User, List<LibraryItem>> checkedOutItemsList, List<LibraryItem> searchResultsList) {
        this.availableItemsList = availableItemsList;
        this.checkedOutItemsList = checkedOutItemsList;
        this.searchResultsList = searchResultsList;
    }

    public String displayAvailableItemsWithAllDetails() {
        String resultItemsInStringFormat = "";
        for (LibraryItem libraryItem : availableItemsList) {
            resultItemsInStringFormat += libraryItem.toString() + "\n";
        }
        return resultItemsInStringFormat;
    }

    public List<LibraryItem> searchItemsByName(String itemName, List<LibraryItem> itemsList) {
        searchResultsList.clear();
        for (LibraryItem libraryItem : itemsList) {
            if (libraryItem.match(itemName))
                searchResultsList.add(libraryItem);
        }
        return searchResultsList;
    }

    public boolean checkOut(String itemName, User user) {
        searchResultsList.clear();
        searchItemsByName(itemName, availableItemsList);
        for (LibraryItem libraryItem : searchResultsList) {
            synchronized (this) {
                availableItemsList.remove(libraryItem);
                addItemToCheckedOutItemsList(user, libraryItem);
            }
            return true;
        }
        return false;
    }

    public boolean returnItem(String itemName, User user) {
        searchResultsList.clear();
        List<LibraryItem> checkedOutItems = checkedOutItemsList.get(user);
        searchItemsByName(itemName, checkedOutItems);
        for (LibraryItem libraryItem : searchResultsList) {
            synchronized (this) {
                removeItemfromCheckedOutItemsList(user, libraryItem);
                availableItemsList.add(libraryItem);
            }
            return true;
        }
        return false;
    }

    private void addItemToCheckedOutItemsList(User user, LibraryItem libraryItem) {
        List<LibraryItem> newItemsList = checkedOutItemsList.get(user);
        newItemsList.add(libraryItem);
        checkedOutItemsList.put(user, newItemsList);
    }

    private void removeItemfromCheckedOutItemsList(User user, LibraryItem libraryItem) {
        List<LibraryItem> currentItemsList = checkedOutItemsList.get(user);
        currentItemsList.remove(libraryItem);
        checkedOutItemsList.put(user, currentItemsList);
    }
}
