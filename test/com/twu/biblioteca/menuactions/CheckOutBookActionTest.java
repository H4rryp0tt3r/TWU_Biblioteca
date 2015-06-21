package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Section;
import com.twu.biblioteca.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static com.twu.biblioteca.BibliotecaAppConstants.FAILED_BOOK_CHECKOUT_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookActionTest {

    @Mock
    LoginAction mockLoginAction;

    @Mock
    Controller mockController;

    @Mock
    User mockUser;

    @Mock
    Section mockBookSection;


    @Test
    public void shouldBeAbleToPerformCheckOutAction() throws IOException {
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(mockBookSection, mockController, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE, mockLoginAction);
        checkOutBookAction.update(mockUser);
        checkOutBookAction.execute();

        verify(mockController).checkOutAnItem(mockBookSection, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE, mockUser);
    }
}
