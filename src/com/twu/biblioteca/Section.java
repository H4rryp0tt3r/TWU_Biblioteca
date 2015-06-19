package com.twu.biblioteca;

import java.util.List;

// This class will holds list of books & a checkout Record. And has methods to Checkout & Return a Book.
public class Section {

    private List<LibraryItem> availableItemsList;
    private List<LibraryItem> checkedOutItemsList;
    private List<LibraryItem> searchResultsList;

    public Section(List<LibraryItem> availableItemsList, List<LibraryItem> checkedOutItemsList, List<LibraryItem> searchResultsList) {
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

    public boolean checkOut(String itemName) {
        searchResultsList.clear();
        searchItemsByName(itemName, availableItemsList);
        for (LibraryItem libraryItem : searchResultsList) {
            synchronized (this) {
                availableItemsList.remove(libraryItem);
                checkedOutItemsList.add(libraryItem);
            }
            return true;
        }
        return false;
    }

    public boolean returnItem(String itemName) {
        searchResultsList.clear();
        searchItemsByName(itemName, checkedOutItemsList);
        for (LibraryItem libraryItem : searchResultsList) {
            synchronized (this) {
                checkedOutItemsList.remove(libraryItem);
                availableItemsList.add(libraryItem);
            }
            return true;
        }
        return false;
    }
}