package com.twu.biblioteca;

public interface BibliotecaAppConstants {
    public static final String WELCOME_MESSAGE = "=== > Welcome to Biblioteca! < ===";
    public static final String LIST_BOOKS_OPTION_DESCRPTION = "List Books";
    public static final String QUIT_OPTION_DESCRIPTION = "Quit";
    public static final String COLUMN_SEPARATOR = "|";
    public static final String BOOK_DETAILS_FORMAT_PATTERN = "%-50s " + COLUMN_SEPARATOR + " %-15s " + COLUMN_SEPARATOR + " %-5s";
    public static final String INVALID_SELECTION_MESSAGE = "Select a valid option!";
    public static final int INVALID_OPTION = -1;
    public static final String SUCCESSFUL_BOOK_CHECKOUT_MESSAGE = "Thank you! Enjoy the Book";
    public static final String FAILED_BOOK_CHECKOUT_MESSAGE = "That book is not available.";
    public static final String CHECKOUT_BOOK_OPTION_DESCRIPTION = "Checkout A Book";
    public static final String RETURN_BOOK_OPTION_DESCRIPTION = "Return A Book";
    public static final String SUCCESSFUL_BOOK_RETURN_MESSAGE = "Thank you for returning the Book";
    public static final String FAILED_BOOK_RETURN_MESSAGE = "That is not a valid Book to return";
    public static final String MENU_PROMPT = "Enter your Option : ";
    public static final String MOVIE_DETAILS_FORMAT_PATTERN = "%-40s " + COLUMN_SEPARATOR + " %-25s " + COLUMN_SEPARATOR + " %-5s" + COLUMN_SEPARATOR + " %-5s";
    public static final String NAME_PROMPT_MESSAGE = "Enter Name : ";
    public static final String LIST_MOVIES_OPTION_DESCRIPTION = "List Movies";
    public static final String CHECKOUT_MOVIE_OPTION_DESCRIPTION = "Checkout A Movie";
    public static final String RETURN_MOVIE_OPTION_DESCRIPTION = "Return A Movie";
    public static final String SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE = "Thank you! Enjoy the Movie";
    public static final String FAILED_MOVIE_CHECKOUT_MESSAGE = "That movie is not available";
    public static final String SUCCESSFUL_MOVIE_RETURN_MESSAGE = "Thank you for returning the Movie";
    public static final String FAILED_MOVIE_RETURN_MESSAGE = "That is not a valid Movie to return";
    public static final String INVALID_CREDENTIALS_MESSAGE = "Invalid Credentials! Please Try Again.";
}
