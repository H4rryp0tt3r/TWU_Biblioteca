package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;

public class PrintProfileAction implements MenuAction, LoginListener {
    private User user;
    private final IOModule ioModule;

    public PrintProfileAction(IOModule ioModule) {
        this.ioModule = ioModule;
    }

    @Override
    public void execute() {
        ioModule.println(user.toString());
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
