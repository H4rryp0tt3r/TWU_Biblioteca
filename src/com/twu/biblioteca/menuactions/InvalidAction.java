package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BibliotecaAppConstants;
import com.twu.biblioteca.menuactions.MenuAction;

public class InvalidAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println(BibliotecaAppConstants.INVALID_SELECTION_MESSAGE);
    }
}