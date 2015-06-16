package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.Library;

import static com.twu.biblioteca.BibliotecaAppConstants.CHECKOUT_PROMPT_MESSAGE;

public class CheckOutAction implements MenuAction {

    private Library library;
    private IOModule ioModule;

    public CheckOutAction(Library library, IOModule ioModule) {
        this.library = library;
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.print(CHECKOUT_PROMPT_MESSAGE);
        String userGivenBookName = ioModule.readInput();
        ioModule.println(library.checkOut(userGivenBookName));
    }
}
