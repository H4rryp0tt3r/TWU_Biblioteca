package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.*;

import java.io.PrintWriter;
import java.util.ArrayList;
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
        HashMap<Integer, String> optionList = new HashMap<>();
        HashMap<Integer, MenuAction> actionList = new HashMap<>();
        ArrayList<Integer> checkedOutBooksSerialNumbers = new ArrayList<>();
        Library library = new Library(listOfBooks, checkedOutBooksSerialNumbers);
        Menu menu = new Menu(optionList, actionList);
        IOModule ioModule = new IOModule(inputReader, outputRenderer);
        optionList.put(-1, null);
        actionList.put(-1, new InvalidAction());
        optionList.put(1, LIST_BOOKS_OPTION_DESCRPTION);
        actionList.put(1, new ListBooksAction(library));
        optionList.put(2, CHECKOUT_OPTION_DESCRIPTION);
        actionList.put(2, new CheckOutBookAction(library, ioModule));
        optionList.put(3, RETURN_BOOK_OPTION_DESCRIPTION);
        actionList.put(3, new ReturnBookAction(library, ioModule));
        optionList.put(4, QUIT_OPTION_DESCRIPTION);
        actionList.put(4, new QuitAction());
        App app = new App(library, ioModule, menu);
        app.start();
    }
}
