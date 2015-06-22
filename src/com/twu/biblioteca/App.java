package com.twu.biblioteca;

import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.controllers.MenuSelector;
import com.twu.biblioteca.menuactions.LogOutAction;
import com.twu.biblioteca.menuactions.LoginAction;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.WELCOME_MESSAGE;

// This Class Uses IOModule to Take User Input And then It gets an appropriate action from Menu and then executes it
public class App implements LoginListener {
    private IOModule ioModule;
    private MenuSelector menuSelector;
    private User user;
    private LoginAction loginAction;
    private LogOutAction logOutAction;

    public App(IOModule ioModule, MenuSelector menuSelector, User user, LoginAction loginAction, LogOutAction logOutAction) {
        this.ioModule = ioModule;
        this.menuSelector = menuSelector;
        this.user = user;
        this.loginAction = loginAction;
        this.loginAction.addListener(this);
        this.logOutAction = logOutAction;
        this.logOutAction.addListener(this);
    }

    public void start() {
        ioModule.println(WELCOME_MESSAGE);
        user.acceptSelector(menuSelector);
    }

    @Override
    public void update(User user) {
        this.user = user;
        this.user.acceptSelector(menuSelector);
    }
}
