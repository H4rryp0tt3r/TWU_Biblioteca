package com.twu.biblioteca;

public interface BibliotecaAppConstants {
    public static final String WELCOME_MESSAGE = "=== > Welcome to Biblioteca! < ===";
    public static final String LIST_BOOKS_OPTION_DESCRPTION = "List Books";
    public static final String QUIT_OPTION_DESCRIPTION = "Quit";
    public static final String COLUMN_SEPARATOR = "|";
    public static final String BOOK_DETAILS_FORMAT_PATTERN = "%-50s " + COLUMN_SEPARATOR + " %-15s " + COLUMN_SEPARATOR + " %-5s";
    public static final String INVALID_SELECTION_MESSAGE = "Select a valid option!";
    public static final int INVALID_OPTION = -1;
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the Book";
    public static final String FAILED_CHECKOUT_MESSAGE = "That book is not available.";

}
