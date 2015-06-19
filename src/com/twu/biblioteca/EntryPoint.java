package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.*;

// This class has all the Initialization of App
public class EntryPoint {
    public static void main(String args[]) {
        Scanner inputReader = new Scanner(System.in);
        IOModule ioModule = new IOModule(inputReader, System.out);

        Controller controller = new Controller(ioModule);

        List<LibraryItem> availableBooksList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        List<LibraryItem> checkedOutBooksList = new ArrayList<>();
        List<LibraryItem> searchResultsList = new ArrayList<>();
        Section bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);

        List<LibraryItem> availableMoviesList = new ArrayList<>();
        availableMoviesList.add(new Movie("H4rryp0tt3r", "Nagesh", "2030", "7.9"));
        availableMoviesList.add(new Movie("Interstellar", "Nolan", "2015", "8.9"));
        availableMoviesList.add(new Movie("Super Man", "Morgan", "1994", "Unrated"));
        List<LibraryItem> checkedOutMoviesList = new ArrayList<>();
        Section movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList);

        HashMap<Integer, String> optionList = new HashMap<>();
        HashMap<Integer, MenuAction> actionList = new HashMap<>();
        Menu menu = new Menu(optionList, actionList, ioModule);
        menu.addOption(-1, null, new InvalidAction());
        menu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(bookSection, controller));
        menu.addOption(2, CHECKOUT_BOOK_OPTION_DESCRIPTION, new CheckOutBookAction(bookSection, controller, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE));
        menu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, new ReturnBookAction(bookSection, controller, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE));
        menu.addOption(4, LIST_MOVIES_OPTION_DESCRIPTION, new ListMoviesAction(movieSection, controller));
        menu.addOption(5, CHECKOUT_MOVIE_OPTION_DESCRIPTION, new CheckOutMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE));
        menu.addOption(6, RETURN_MOVIE_OPTION_DESCRIPTION, new ReturnMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE));
        menu.addOption(7, QUIT_OPTION_DESCRIPTION, new QuitAction());

        App app = new App(menu, ioModule);
        app.start();
    }
}
