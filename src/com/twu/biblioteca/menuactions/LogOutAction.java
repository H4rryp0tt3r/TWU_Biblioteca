package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.views.IOModule;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.LOGOUT_SUCCESS_MESSAGE;

public class LogOutAction implements MenuAction {
    private IOModule ioModule;
    private LoginListener loginListener;

    public LogOutAction(IOModule ioModule) {
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.println(LOGOUT_SUCCESS_MESSAGE);
        loginListener.update(Guest.create());
    }

    public void addListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
}
