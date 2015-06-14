package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.Library;

import static com.twu.biblioteca.BibliotecaAppConstants.CHECKOUT_PROMPT_MESSAGE;

// This Class executes the Checkout Book Action
public class CheckOutBookAction implements MenuAction {
    private Library library;
    private IOModule ioModule;

    public CheckOutBookAction(Library library, IOModule ioModule) {
        this.library = library;
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.print(CHECKOUT_PROMPT_MESSAGE);
        int userChoosenBookSno = getBookSNoAsInteger();
        System.out.println(library.checkOutABook(userChoosenBookSno));
    }

    private int getBookSNoAsInteger() {
        return Integer.parseInt(ioModule.readInput());
    }
}
