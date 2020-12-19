package com.twu.biblioteca;

import com.twu.biblioteca.controllers.Authenticator;
import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.controllers.MenuSelector;
import com.twu.biblioteca.menuactions.*;
import com.twu.biblioteca.models.*;
import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.users.Librarian;
import com.twu.biblioteca.users.Member;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.*;

// This class has all the Initialization of App
public class EntryPoint {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        IOModule ioModule = new IOModule(inputReader, System.out);

        Controller controller = new Controller(ioModule);

        User guest = new Guest();
        User member = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        User librarian = new Librarian("111-1111", "password", "Librarian", "librarian@librarians.com", "9876543210");
        List<User> userDB = new ArrayList<>();
        userDB.add(member);
        userDB.add(librarian);


        Authenticator authenticator = new Authenticator(userDB);

        List<LibraryItem> availableBooksList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        HashMap<User, List<LibraryItem>> checkedOutBooksList = new HashMap<>();
        checkedOutBooksList.put(member, new ArrayList<>());
        checkedOutBooksList.put(librarian, new ArrayList<>());
        List<LibraryItem> searchResultsList = new ArrayList<>();
        Section bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);

        List<LibraryItem> availableMoviesList = new ArrayList<>();
        availableMoviesList.add(new Movie("H4rryp0tt3r", "Nagesh", "2030", "7.9"));
        availableMoviesList.add(new Movie("Interstellar", "Nolan", "2015", "8.9"));
        availableMoviesList.add(new Movie("Super Man", "Morgan", "1994", "Unrated"));
        HashMap<User, List<LibraryItem>> checkedOutMoviesList = new HashMap<>();
        checkedOutMoviesList.put(member, new ArrayList<>());
        checkedOutMoviesList.put(librarian, new ArrayList<>());
        Section movieSection = new Section(availableMoviesList, checkedOutMoviesList, searchResultsList);

        List<LoginListener> listenerList = new ArrayList<>();
        LoginAction loginAction = new LoginAction(authenticator, ioModule, listenerList);
        LogOutAction logOutAction = new LogOutAction(ioModule);
        PrintProfileAction printProfileAction = new PrintProfileAction(ioModule);
        loginAction.addListener(printProfileAction);
        ListBooksAction listBooksAction = new ListBooksAction(bookSection, controller);
        ListMoviesAction listMoviesAction = new ListMoviesAction(movieSection, controller);
        QuitAction quitAction = new QuitAction();
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(bookSection, controller, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE);
        loginAction.addListener(checkOutBookAction);
        ReturnBookAction returnBookAction = new ReturnBookAction(bookSection, controller, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE);
        loginAction.addListener(returnBookAction);
        CheckOutMovieAction checkOutMovieAction = new CheckOutMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE);
        loginAction.addListener(checkOutMovieAction);
        ReturnMovieAction returnMovieAction = new ReturnMovieAction(movieSection, controller, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE);
        loginAction.addListener(returnMovieAction);
        PrintCheckOutHistoryAction printCheckOutHistoryAction = new PrintCheckOutHistoryAction(bookSection, movieSection, ioModule);


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
        memberMenu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, listBooksAction);
        memberMenu.addOption(2, CHECKOUT_BOOK_OPTION_DESCRIPTION, checkOutBookAction);
        memberMenu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, returnBookAction);
        memberMenu.addOption(4, LIST_MOVIES_OPTION_DESCRIPTION, listMoviesAction);
        memberMenu.addOption(5, CHECKOUT_MOVIE_OPTION_DESCRIPTION, checkOutMovieAction);
        memberMenu.addOption(6, RETURN_MOVIE_OPTION_DESCRIPTION, returnMovieAction);
        memberMenu.addOption(7, PRINT_PROFILE_OPTION_DESCRIPTION, printProfileAction);
        memberMenu.addOption(8, LOGOUT_OPTION_DESCRIPTION, logOutAction);

        HashMap<Integer, String> librarianOptionList = new HashMap<>();
        HashMap<Integer, MenuAction> librarianActionList = new HashMap<>();
        Menu librarianMenu = new Menu(librarianOptionList, librarianActionList, ioModule);
        librarianMenu.addOption(-1, null, new InvalidAction());
        librarianMenu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, listBooksAction);
        librarianMenu.addOption(2, CHECKOUT_BOOK_OPTION_DESCRIPTION, checkOutBookAction);
        librarianMenu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, returnBookAction);
        librarianMenu.addOption(4, LIST_MOVIES_OPTION_DESCRIPTION, listMoviesAction);
        librarianMenu.addOption(5, CHECKOUT_MOVIE_OPTION_DESCRIPTION, checkOutMovieAction);
        librarianMenu.addOption(6, RETURN_MOVIE_OPTION_DESCRIPTION, returnMovieAction);
        librarianMenu.addOption(7, PRINT_CHECKOUT_HISTORY_OPTION_DESCRIPTION, printCheckOutHistoryAction);
        librarianMenu.addOption(8, PRINT_PROFILE_OPTION_DESCRIPTION, printProfileAction);
        librarianMenu.addOption(9, LOGOUT_OPTION_DESCRIPTION, logOutAction);
        librarianMenu.addOption(10, QUIT_OPTION_DESCRIPTION, quitAction);

        MenuSelector menuSelector = new MenuSelector(guestMenu, memberMenu, librarianMenu);


        App bibliotecaApp = new App(ioModule, menuSelector, guest);
        loginAction.addListener(bibliotecaApp);
        logOutAction.addListener(bibliotecaApp);
        bibliotecaApp.start();
    }
}
