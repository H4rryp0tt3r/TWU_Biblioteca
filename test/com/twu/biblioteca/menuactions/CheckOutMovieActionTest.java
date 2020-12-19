package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.FAILED_MOVIE_CHECKOUT_MESSAGE;
import static com.twu.biblioteca.constants.BibliotecaAppConstants.SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutMovieActionTest {

    @Mock
    Section movieSection;

    @Mock
    User mockUser;

    @Mock
    Controller mockController;


    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        CheckOutMovieAction checkOutMovieAction = new CheckOutMovieAction(movieSection, mockController, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE);
        checkOutMovieAction.update(mockUser);
        checkOutMovieAction.execute();

        verify(mockController).checkOutAnItem(movieSection, SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, FAILED_MOVIE_CHECKOUT_MESSAGE, mockUser);
    }
}
