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

        List<User> userDB = new ArrayList<>();
        userDB.add(new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890"));
        userDB.add(new Librarian("111-1111", "password", "Librarian", "librarian@librarians.com", "9876543210"));

        User user = new Guest();

        Authenticator authenticator = new Authenticator(userDB);

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

        List<LoginListener> listenerList = new ArrayList<>();
        LoginAction loginAction = new LoginAction(authenticator, ioModule, listenerList);
        LogOutAction logOutAction = new LogOutAction(ioModule);
        PrintProfileAction printProfileAction = new PrintProfileAction(ioModule, loginAction);

        HashMap<Integer, String> guestOptionList = new HashMap<>();
        HashMap<Integer, MenuAction> guestActionList = new HashMap<>();
        Menu guestMenu = new Menu(guestOptionList, guestActionList, ioModule);
        guestMenu.addOption(-1, null, new InvalidAction());
        guestMenu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(bookSection, controller));
        guestMenu.addOption(2, LIST_MOVIES_OPTION_DESCRIPTION, new ListMoviesAction(movieSection, controller));
        guestMenu.addOption(3, LOGIN_OPTION_DESCRIPTION, loginAction);

        HashMap<Integer, String> memberOptionList = new HashMap<>();
        HashMap<Integer, MenuAction> memberActionList = new HashMap<>();
        Menu memberMenu = new Menu(memberOptionList, memberActionList, ioModule);
        memberMenu.addOption(-1, null, new InvalidAction());
        memberMenu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(bookSection, controller));
        memberMenu.addOption(2, CHECKOUT_BOOK_OPTION_DESCRIPTION, new CheckOutBookAction(bookSection, controller, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE));
        memberMenu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, new ReturnBookAction(bookSection, controller, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE));
        memberMenu.addOption(4, LIST_MOVIES_OPTION_DESCRIPTION, new ListMoviesAction(movieSection, controller));
        memberMenu.addOption(5, CHECKOUT_MOVIE_OPTION_DESCRIPTION, new CheckOutMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE));
        memberMenu.addOption(6, RETURN_MOVIE_OPTION_DESCRIPTION, new ReturnMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE));
        memberMenu.addOption(7, PRINT_PROFILE_OPTION_DESCRIPTION, printProfileAction);
        memberMenu.addOption(8, LOGOUT_OPTION_DESCRIPTION, logOutAction);

        HashMap<Integer, String> librarianOptionList = new HashMap<>();
        HashMap<Integer, MenuAction> librarianActionList = new HashMap<>();
        Menu librarianMenu = new Menu(librarianOptionList, librarianActionList, ioModule);
        librarianMenu.addOption(-1, null, new InvalidAction());
        librarianMenu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(bookSection, controller));
        librarianMenu.addOption(2, CHECKOUT_BOOK_OPTION_DESCRIPTION, new CheckOutBookAction(bookSection, controller, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE));
        librarianMenu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, new ReturnBookAction(bookSection, controller, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE));
        librarianMenu.addOption(4, LIST_MOVIES_OPTION_DESCRIPTION, new ListMoviesAction(movieSection, controller));
        librarianMenu.addOption(5, CHECKOUT_MOVIE_OPTION_DESCRIPTION, new CheckOutMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE));
        librarianMenu.addOption(6, RETURN_MOVIE_OPTION_DESCRIPTION, new ReturnMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE));
        librarianMenu.addOption(7, PRINT_PROFILE_OPTION_DESCRIPTION, printProfileAction);
        librarianMenu.addOption(8, LOGOUT_OPTION_DESCRIPTION, logOutAction);
        librarianMenu.addOption(9, QUIT_OPTION_DESCRIPTION, new QuitAction());

        MenuSelector menuSelector = new MenuSelector(guestMenu, memberMenu, librarianMenu);


        App bibliotecaApp = new App(ioModule, menuSelector, user, loginAction, logOutAction);
        bibliotecaApp.start();
    }
}
