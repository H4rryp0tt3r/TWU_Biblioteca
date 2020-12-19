package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.controllers.Controller;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.FAILED_BOOK_RETURN_MESSAGE;
import static com.twu.biblioteca.constants.BibliotecaAppConstants.SUCCESSFUL_BOOK_RETURN_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {

    @Mock
    Controller mockController;

    @Mock
    User mockUser;

    @Mock
    Section mockBookSection;

    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        ReturnBookAction returnBookAction = new ReturnBookAction(mockBookSection, mockController, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE);
        returnBookAction.update(mockUser);
        returnBookAction.execute();

        verify(mockController).returnAnItem(mockBookSection, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE, mockUser);
    }

}
