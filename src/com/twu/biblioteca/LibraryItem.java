package com.twu.biblioteca;

public interface LibraryItem {
    boolean match(String itemName);

    String toString();

    boolean equals(Object otherObject);
}
