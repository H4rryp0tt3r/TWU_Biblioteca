package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Authenticator;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;

import java.util.List;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.LIBRARY_NUMBER_PROMPT;
import static com.twu.biblioteca.constants.BibliotecaAppConstants.LIBRARY_PASSWORD_PROMPT;

public class LoginAction implements MenuAction {
    private final Authenticator authenticator;
    private final IOModule ioModule;
    private final List<LoginListener> loginListeners;

    public LoginAction(Authenticator authenticator, IOModule ioModule, List<LoginListener> loginListeners) {
        this.authenticator = authenticator;
        this.ioModule = ioModule;
        this.loginListeners = loginListeners;
    }

    @Override
    public void execute() {
        ioModule.print(LIBRARY_NUMBER_PROMPT);
        String libraryNumber = ioModule.readInput();
        ioModule.print(LIBRARY_PASSWORD_PROMPT);
        String password = ioModule.readInput();
        User user = authenticator.authenticate(libraryNumber, password);
        ioModule.println(user.statusMessage());
        for (LoginListener listener : loginListeners) {
            listener.update(user);
        }
    }

    public void addListener(LoginListener loginListener) {
        loginListeners.add(loginListener);
    }
}
