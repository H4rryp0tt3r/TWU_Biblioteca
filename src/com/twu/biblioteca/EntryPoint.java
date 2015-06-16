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
        List<Book> availableBooksList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        List<Book> checkedOutBooksList = new ArrayList<>();
        HashMap<Integer, String> optionList = new HashMap<>();
        HashMap<Integer, MenuAction> actionList = new HashMap<>();
        IOModule ioModule = new IOModule(inputReader, System.out);
        List<Book> searchResultsList = new ArrayList<>();
        Library library = new Library(availableBooksList, checkedOutBooksList, searchResultsList, ioModule);
        Menu menu = new Menu(optionList, actionList);
        menu.addOption(-1, null, new InvalidAction());
        menu.addOption(1, LIST_BOOKS_OPTION_DESCRPTION, new ListBooksAction(library));
        menu.addOption(2, CHECKOUT_OPTION_DESCRIPTION, new CheckOutBookAction(library, ioModule));
        menu.addOption(3, RETURN_BOOK_OPTION_DESCRIPTION, new ReturnBookAction(library, ioModule));
        menu.addOption(4, QUIT_OPTION_DESCRIPTION, new QuitAction());
        App app = new App(library, ioModule, menu);
        app.start();
    }
}
