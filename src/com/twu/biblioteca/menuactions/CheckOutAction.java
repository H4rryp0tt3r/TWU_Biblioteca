package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Book;

public class CheckOutAction implements MenuAction {
    private Book book;

    public CheckOutAction(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        System.out.println(book.checkOut());
    }
}
