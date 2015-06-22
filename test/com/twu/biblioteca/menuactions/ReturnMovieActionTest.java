package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.FAILED_MOVIE_RETURN_MESSAGE;
import static com.twu.biblioteca.constants.BibliotecaAppConstants.SUCCESSFUL_MOVIE_RETURN_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {

    @Mock
    LoginAction mockLoginAction;

    @Mock
    Controller mockController;

    @Mock
    Section mockMovieSection;

    @Mock
    User mockUser;


    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        ReturnMovieAction returnMovieAction = new ReturnMovieAction(mockMovieSection, mockController, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE, mockLoginAction);
        returnMovieAction.update(mockUser);
        returnMovieAction.execute();

        verify(mockController).returnAnItem(mockMovieSection, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE, mockUser);
    }
}
