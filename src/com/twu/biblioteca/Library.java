package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks;

    public Library(){
        listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Sample Book1","Nagesh","2009"));
        listOfBooks.add(new Book("Sample Book2","Naresh","2010"));
        listOfBooks.add(new Book("Sample Book3","Ganesh","2011"));
    }

    public void displayBookListWithAllDetails() {
        for(int i=0;i<listOfBooks.size();i++) {
            System.out.println(listOfBooks.get(i));
        }
    }
}
