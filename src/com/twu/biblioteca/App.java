package com.twu.biblioteca;

import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.controllers.MenuSelector;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.WELCOME_MESSAGE;

// This Class Uses IOModule to Take User Input And then It gets an appropriate action from Menu and then executes it
public class App implements LoginListener {
    private final IOModule ioModule;
    private final MenuSelector menuSelector;
    private User user;

    public App(IOModule ioModule, MenuSelector menuSelector, User user) {
        this.ioModule = ioModule;
        this.menuSelector = menuSelector;
        this.user = user;
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
