package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.InvalidAction;
import com.twu.biblioteca.menuactions.ListBooksAction;
import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.LIST_BOOKS_OPTION_DESCRPTION;
import static com.twu.biblioteca.BibliotecaAppConstants.QUIT_OPTION_DESCRIPTION;

public class BibliotecaEntryPoint {
    public static void main(String args[]) {
        Scanner inputReader = new Scanner(System.in);
        PrintWriter outputRenderer = new PrintWriter(System.out, true);
        HashMap<Integer, Book> listOfBooks = new HashMap();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        Library library = new Library(listOfBooks);
        HashMap<Integer, String> optionList = new HashMap<>();
        HashMap<Integer, MenuAction> actionList = new HashMap<>();
        optionList.put(-1, "Invalid Option");
        actionList.put(-1, new InvalidAction());
        optionList.put(1, LIST_BOOKS_OPTION_DESCRPTION);
        actionList.put(1, new ListBooksAction(library));
        optionList.put(2, QUIT_OPTION_DESCRIPTION);
        actionList.put(2, new QuitAction());
        Menu menu = new Menu(optionList, actionList);
        IOModule ioModule = new IOModule(inputReader, outputRenderer);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library, ioModule, menu);
        bibliotecaApp.start();
    }
}
