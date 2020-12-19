package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuSelector;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.WELCOME_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @Mock
    IOModule mockIOModule;

    @Mock
    MenuSelector mockMenuSelector;

    @Mock
    User mockUser;

    private App bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new App(mockIOModule, mockMenuSelector, mockUser);
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() {
        bibliotecaApp.start();

        verify(mockIOModule).println(WELCOME_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPerformAnActionBasedOnUserInput() {
        bibliotecaApp.start();

        verify(mockUser).acceptSelector(mockMenuSelector);
    }

    @Test
    public void shouldBeAbleToUpdateUserInformationUponLoginAction() {
        bibliotecaApp.update(mockUser);

        verify(mockUser).acceptSelector(mockMenuSelector);
    }
}
