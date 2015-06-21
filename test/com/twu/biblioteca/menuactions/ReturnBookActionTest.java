package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

import static com.twu.biblioteca.BibliotecaAppConstants.FAILED_BOOK_RETURN_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_BOOK_RETURN_MESSAGE;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {

    @Mock
    Controller mockController;

    @Mock
    User mockUser;

    @Mock
    Section mockBookSection;

    @Mock
    LoginAction mockLogicAction;

    @Test
    public void shouldBeAbleToPerformCheckOutAction() {
        ReturnBookAction returnBookAction = new ReturnBookAction(mockBookSection, mockController, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE, mockLogicAction);
        returnBookAction.update(mockUser);
        returnBookAction.execute();

        verify(mockController).returnAnItem(mockBookSection,SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE, mockUser);
    }

}
