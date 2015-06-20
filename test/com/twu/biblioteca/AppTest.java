package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.LogOutAction;
import com.twu.biblioteca.menuactions.LoginAction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.BibliotecaAppConstants.WELCOME_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @Mock
    IOModule mockIOModule;

    @Mock
    MenuSelector mockMenuSelector;

    @Mock
    User mockUser;

    @Mock
    LoginAction mockLoginAction;

    @Mock
    LogOutAction mockLogOutAction;

    private App bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new App(mockIOModule, mockMenuSelector, mockUser, mockLoginAction, mockLogOutAction);
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() {
        bibliotecaApp.start();

        verify(mockIOModule).println(WELCOME_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPeformAnActionBasedOnUserInput() {
        bibliotecaApp.start();

        verify(mockUser).acceptSelector(mockMenuSelector);
    }
}
