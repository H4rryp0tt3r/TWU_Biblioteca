package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.BibliotecaAppConstants.FAILED_MOVIE_CHECKOUT_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutMovieActionTest {

    @Mock
    Section movieSection;

    @Mock
    User mockUser;

    @Mock
    Controller mockController;

    @Mock
    LoginAction mockLoginAction;


    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        CheckOutMovieAction checkOutMovieAction = new CheckOutMovieAction(movieSection, mockController, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE, mockLoginAction);
        checkOutMovieAction.update(mockUser);
        checkOutMovieAction.execute();

        verify(mockController).checkOutAnItem(movieSection,SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE, mockUser);
    }

    @After
    public void cleanUp() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }
}
