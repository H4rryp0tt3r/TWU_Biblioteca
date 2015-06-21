package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.IOModule;
import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.User;

public class PrintProfileAction implements MenuAction, LoginListener {
    private User user;
    private LoginAction loginAction;
    private IOModule ioModule;

    public PrintProfileAction(IOModule ioModule, LoginAction loginActionParam) {
        this.ioModule = ioModule;
        this.loginAction = loginActionParam;
        loginAction.addListener(this);
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
