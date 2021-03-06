package com.twu.biblioteca.constants;

public final class BibliotecaAppConstants {
    public static final String WELCOME_MESSAGE = "+--------------------------------------------------+\n" +
            "|              Welcome to Biblioteca               |\n" +
            "+--------------------------------------------------+\n";
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
    public static final String MOVIE_DETAILS_FORMAT_PATTERN = "%-29s " + COLUMN_SEPARATOR + " %-25s " + COLUMN_SEPARATOR + " %-5s" + COLUMN_SEPARATOR + " %-9s";
    public static final String NAME_PROMPT_MESSAGE = "Enter Name : ";
    public static final String LIST_MOVIES_OPTION_DESCRIPTION = "List Movies";
    public static final String CHECKOUT_MOVIE_OPTION_DESCRIPTION = "Checkout A Movie";
    public static final String RETURN_MOVIE_OPTION_DESCRIPTION = "Return A Movie";
    public static final String SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE = "Thank you! Enjoy the Movie";
    public static final String FAILED_MOVIE_CHECKOUT_MESSAGE = "That movie is not available";
    public static final String SUCCESSFUL_MOVIE_RETURN_MESSAGE = "Thank you for returning the Movie";
    public static final String FAILED_MOVIE_RETURN_MESSAGE = "That is not a valid Movie to return";
    public static final String INVALID_CREDENTIALS_MESSAGE = "Invalid Credentials! Please Try Again.";
    public static final String LIBRARIAN_LOGIN_STATUS_MESSAGE = "Success!! You logged in as Librarian.";
    public static final String MEMBER_LOGIN_STATUS_MESSAGE = "Success!! You logged in as Member.";
    public static final String LIBRARY_NUMBER_PROMPT = "Enter your Library Number : ";
    public static final String LIBRARY_PASSWORD_PROMPT = "Enter your Password : ";
    public static final String LOGIN_OPTION_DESCRIPTION = "Login Now";
    public static final String LOGOUT_SUCCESS_MESSAGE = "You have successfully Logged Out!";
    public static final String LOGOUT_OPTION_DESCRIPTION = "Logout";
    public static final String USER_DETAILS_FORMAT_PATTERN = "| Library Number : %s |\n| Full Name : %s |\n| Email Address : %s |\n| Phone Number : %s|\n";
    public static final String PRINT_PROFILE_OPTION_DESCRIPTION = "Your Profile";
    public static final String USER_BASIC_DETAILS_FORMAT_PATTERN = "| %s : %-15s |";
    public static final String HISTORY_PRINTING_PATTERN = "%s => | %s |";
    public static final String PRINT_CHECKOUT_HISTORY_OPTION_DESCRIPTION = "Print CheckOut Details";

    private BibliotecaAppConstants() {
    }
}
