package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<String> listOfBooks;

    public Library(){
        listOfBooks = new ArrayList<String>();
        listOfBooks.add(new String("Sample Book1"));
        listOfBooks.add(new String("Sample Book2"));
        listOfBooks.add(new String("Sample Book3"));
        listOfBooks.add(new String("Sample Book4"));
    }

    public void displayBookListByName() {
        for(int i=0;i<listOfBooks.size();i++) {
            System.out.println(listOfBooks.get(i));
        }
    }
}
