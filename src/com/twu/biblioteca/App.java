package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.LoginAction;
import com.twu.biblioteca.menuactions.MenuAction;
import com.twu.biblioteca.menuactions.QuitAction;

import static com.twu.biblioteca.BibliotecaAppConstants.WELCOME_MESSAGE;

// This Class Uses IOModule to Take User Input And then It gets an appropriate action from Menu and then executes it
public class App implements LoginListener {
    private IOModule ioModule;
    private MenuSelector menuSelector;
    private User user;
    private LoginAction loginAction;

    public App(IOModule ioModule, MenuSelector menuSelector, User user, LoginAction loginAction) {
        this.ioModule = ioModule;
        this.menuSelector = menuSelector;
        this.user = user;
        this.loginAction = loginAction;
        this.loginAction.addListener(this);
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
