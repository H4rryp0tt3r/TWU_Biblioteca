package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.User;

import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARY_NUMBER_PROMPT;
import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARY_PASSWORD_PROMPT;

public class LoginAction implements MenuAction {
    private Authenticator authenticator;
    private IOModule ioModule;
    private LoginListener loginListener;

    public LoginAction(Authenticator authenticator, IOModule ioModule) {
        this.authenticator = authenticator;
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.print(LIBRARY_NUMBER_PROMPT);
        String libraryNumber = ioModule.readInput();
        ioModule.print(LIBRARY_PASSWORD_PROMPT);
        String password = ioModule.readInput();
        User user = authenticator.authenticate(libraryNumber, password);
        ioModule.println(user.statusMessage());
        loginListener.update(user);
    }

    public void addListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
}
