package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Authenticator;
import com.twu.biblioteca.controllers.LoginListener;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginActionTest {

    @Mock
    IOModule mockIOModule;

    @Mock
    User mockUser;

    @Mock
    Authenticator mockAuthenticator;

    @Mock
    LoginListener mockLoginListener;

    @Mock
    List<LoginListener> mockLoginListeners;

    private List<LoginListener> loginListeners;

    @Before
    public void setUp() {
        loginListeners = new ArrayList<>();
    }

    @Test
    public void shouldBeAbleToAddListeners() {
        LoginAction loginAction = new LoginAction(mockAuthenticator, mockIOModule, mockLoginListeners);
        loginAction.addListener(mockLoginListener);

        verify(mockLoginListeners).add(mockLoginListener);
    }

    @Test
    public void shouldBeAbleToPrintUserLoginStatusMessage() {
        LoginAction loginAction = new LoginAction(mockAuthenticator, mockIOModule, loginListeners);
        loginAction.addListener(mockLoginListener);
        when(mockIOModule.readInput()).thenReturn("111-1111", "s3cr3t");
        when(mockAuthenticator.authenticate("111-1111", "s3cr3t")).thenReturn(mockUser);
        when(mockUser.statusMessage()).thenReturn("Success");
        mockLoginListener.update(mockUser);
        loginAction.execute();

        verify(mockIOModule).println("Success");
    }
}
