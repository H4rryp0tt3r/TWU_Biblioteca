package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrintProfileActionTest {

    @Mock
    IOModule mockIOModule;

    @Mock
    User mockUser;

    @Mock
    LoginAction mockLoginAction;

    @Test
    public void shoudlBeAbleToPrintUserProfile() {
        PrintProfileAction printProfileAction = new PrintProfileAction(mockIOModule, mockLoginAction);
        when(mockUser.toString()).thenReturn("User details");
        printProfileAction.update(mockUser);
        printProfileAction.execute();

        verify(mockIOModule).println("User details");
    }
}
