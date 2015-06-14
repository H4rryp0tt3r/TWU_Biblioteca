package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.Library;

import static com.twu.biblioteca.BibliotecaAppConstants.RETURN_PROMPT_MESSAGE;

public class ReturnBookAction implements MenuAction {
    private Library library;
    private IOModule ioModule;

    public ReturnBookAction(Library library, IOModule ioModule) {
        this.library = library;
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.print(RETURN_PROMPT_MESSAGE);
        int userChoosenBookSno = getBookSNoAsInteger();
        System.out.println(library.returnABook(userChoosenBookSno));
    }

    private int getBookSNoAsInteger() {
        return Integer.parseInt(ioModule.readInput());
    }
}
