package com.twu.biblioteca;

import com.twu.biblioteca.menuactions.ListBooksAction;
import com.twu.biblioteca.menuactions.QuitAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaAppConstants.WELCOME_MESSAGE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());

    @Mock
    Menu mockMenu;

    @Mock
    IOModule mockIOModule;

    @Mock
    ListBooksAction listBooksAction;

    @Mock
    QuitAction quitAction;

    private App bibliotecaApp;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
        bibliotecaApp = new App(mockMenu, mockIOModule);
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() {
        when(mockIOModule.readInput()).thenReturn("4\n");
        when(mockMenu.chooseOption()).thenReturn(quitAction);
        bibliotecaApp.start();

        verify(mockIOModule).println(WELCOME_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPeformAnActionBasedOnUserInput() {
        when(mockIOModule.readInput()).thenReturn("4\n");
        when(mockMenu.chooseOption()).thenReturn(quitAction);
        bibliotecaApp.start();

        verify(mockMenu).chooseOption();
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(System.in);
    }
}
