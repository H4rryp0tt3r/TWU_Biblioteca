package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.*;

public class EntryPoint {
    public static void main(String args[]) {
        Scanner inputReader = new Scanner(System.in);
        PrintWriter outputRenderer = new PrintWriter(System.out, true);
        HashMap<Integer, Book> listOfBooks = new HashMap();
        listOfBooks.put(1, new Book("Sample Book1", "Nagesh", "2009"));
        listOfBooks.put(2, new Book("Sample Book2", "Naresh", "2010"));
        listOfBooks.put(3, new Book("Sample Book3", "Ganesh", "2011"));
        Book dummyBook = new Book("Dummy", "Dummy", "Dummy");
        Library library = new Library(listOfBooks);
        HashMap<Integer, String> optionList = new HashMap<>();
        HashMap<Integer, MenuAction> actionList = new HashMap<>();
        optionList.put(-1, null);
        actionList.put(-1, new InvalidAction());
        optionList.put(1, LIST_BOOKS_OPTION_DESCRPTION);
        actionList.put(1, new ListBooksAction(library));
        optionList.put(2, CHECKOUT_OPTION_DESCRIPTION);
        actionList.put(2, new CheckOutAction(dummyBook));
        optionList.put(3, QUIT_OPTION_DESCRIPTION);
        actionList.put(3, new QuitAction());
        Menu menu = new Menu(optionList, actionList);
        IOModule ioModule = new IOModule(inputReader, outputRenderer);
        App app = new App(library, ioModule, menu);
        app.start();
    }
}
