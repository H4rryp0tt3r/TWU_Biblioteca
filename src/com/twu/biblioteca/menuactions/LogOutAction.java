package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.BibliotecaAppConstants;
import com.twu.biblioteca.Guest;
import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.LoginListener;

import static com.twu.biblioteca.BibliotecaAppConstants.*;

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
