package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.BibliotecaAppConstants.*;

// This class will holds list of books & a checkout Record. And has methods to Checkout & Return a Book.
public class Library {

    private HashMap<Integer, Book> listOfBooks;
    private ArrayList<Integer> checkedOutBooksSerialNumbers;

    public Library(HashMap<Integer, Book> listOfBooks, ArrayList<Integer> checkedOutBooksSerialNumbers) {
        this.listOfBooks = listOfBooks;
        this.checkedOutBooksSerialNumbers = checkedOutBooksSerialNumbers;
    }

    public void displayBookListWithAllDetails() {
        for (Integer index : listOfBooks.keySet()) {
            Book book = listOfBooks.get(index);
            if (!inInCheckedOutBooksList(index))
                System.out.println(index + " " + COLUMN_SEPARATOR + " " + book);
        }
        System.out.println();
    }

    public String checkOutABook(int userChoosenBookSno) {
        boolean isCheckedOut = inInCheckedOutBooksList(userChoosenBookSno);
        if (!isAValidBookSNo(userChoosenBookSno))
            return FAILED_CHECKOUT_MESSAGE;
        if (isCheckedOut)
            return FAILED_CHECKOUT_MESSAGE;
        checkedOutBooksSerialNumbers.add(userChoosenBookSno);
        return SUCCESSFUL_CHECKOUT_MESSAGE;
    }

    public String returnABook(int userChoosenBookSno) {
        boolean isCheckedOut = inInCheckedOutBooksList(userChoosenBookSno);
        if (!isAValidBookSNo(userChoosenBookSno))
            return FAILED_RETURN_MESSAGE;
        if (!isCheckedOut)
            return FAILED_RETURN_MESSAGE;
        removeBookNoFromCheckOutBooksList(userChoosenBookSno);
        return SUCCESSFUL_RETURN_MESSAGE;
    }

    private void removeBookNoFromCheckOutBooksList(int userChoosenBookSno) {
        for (int index = 0; index < checkedOutBooksSerialNumbers.size(); index++) {
            if (checkedOutBooksSerialNumbers.get(index) == userChoosenBookSno)
                checkedOutBooksSerialNumbers.remove(index);
        }
    }

    private boolean isAValidBookSNo(int userChoosenBookSno) {
        for (Integer index : listOfBooks.keySet()) {
            if (index == userChoosenBookSno)
                return true;
        }
        return false;
    }

    private boolean inInCheckedOutBooksList(int userChoosenBookSno) {
        return checkedOutBooksSerialNumbers.contains(userChoosenBookSno);
    }
}
