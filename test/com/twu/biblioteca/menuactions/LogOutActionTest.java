package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogOutActionTest {

    @Mock
    IOModule mockIOModule;

    @Mock
    User mockUser;

    @Mock
    LoginListener mockLoginListener;

    @Test
    public void shouldBeAbleToPerformLogOutAction() {
        LogOutAction logOutAction = new LogOutAction(mockIOModule);
        logOutAction.addListener(mockLoginListener);
        mockIOModule.println("SUCCESS");
        mockLoginListener.update(mockUser);
        logOutAction.execute();

        verify(mockIOModule).println("SUCCESS");
    }
}
