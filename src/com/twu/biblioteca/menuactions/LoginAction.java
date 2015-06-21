package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.User;

import java.util.List;

import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARY_NUMBER_PROMPT;
import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARY_PASSWORD_PROMPT;

public class LoginAction implements MenuAction {
    private Authenticator authenticator;
    private IOModule ioModule;
    private List<LoginListener> loginListeners;

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
        updateAllListeners(loginListeners, user);
    }

    private void updateAllListeners(List<LoginListener> listeners, User user) {
        for (LoginListener listener : listeners) {
            listener.update(user);
        }
    }

    public void addListener(LoginListener loginListener) {
        loginListeners.add(loginListener);
    }
}
