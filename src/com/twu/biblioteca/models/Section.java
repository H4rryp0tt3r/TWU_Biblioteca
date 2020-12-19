package com.twu.biblioteca.models;

import com.twu.biblioteca.users.User;

import java.util.HashMap;
import java.util.List;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.HISTORY_PRINTING_PATTERN;

// This class will holds list of books & a checkout Record. And has methods to Checkout & Return a Book.
public class Section {

    private final List<LibraryItem> availableItemsList;
    private final HashMap<User, List<LibraryItem>> checkedOutItemsList;
    private final List<LibraryItem> searchResultsList;

    public Section(List<LibraryItem> availableItemsList, HashMap<User, List<LibraryItem>> checkedOutItemsList, List<LibraryItem> searchResultsList) {
        this.availableItemsList = availableItemsList;
        this.checkedOutItemsList = checkedOutItemsList;
        this.searchResultsList = searchResultsList;
    }

    public String displayAvailableItemsWithAllDetails() {
        StringBuilder resultItemsInStringFormat = new StringBuilder("\n-------------------------------------------------------------------------------\n");
        for (LibraryItem libraryItem : availableItemsList) {
            resultItemsInStringFormat.append("| ").append(libraryItem.toString()).append("|\n");
        }
        resultItemsInStringFormat.append("-------------------------------------------------------------------------------\n");
        return resultItemsInStringFormat.toString();
    }

    public void searchItemsByName(String itemName, List<LibraryItem> itemsList) {
        searchResultsList.clear();
        for (LibraryItem libraryItem : itemsList) {
            if (libraryItem.match(itemName))
                searchResultsList.add(libraryItem);
        }
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

    public String displayCheckedOutItemDetails() {
        StringBuilder itemDetails = new StringBuilder();
        for (User user : checkedOutItemsList.keySet()) {
            for (LibraryItem libraryItem : checkedOutItemsList.get(user)) {
                itemDetails.append(String.format(HISTORY_PRINTING_PATTERN, user.getUserBasicDetails(), libraryItem.toString())).append("\n");
            }
        }
        return itemDetails.toString();
    }
}
