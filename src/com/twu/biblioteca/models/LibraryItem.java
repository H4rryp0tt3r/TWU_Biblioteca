package com.twu.biblioteca.models;

public interface LibraryItem {
    boolean match(String itemName);

    String toString();

    boolean equals(Object otherObject);
}
