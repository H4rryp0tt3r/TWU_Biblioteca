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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());

    @Mock
    Menu mockMenu;

    @Mock
    Library mockLibrary;

    @Mock
    IOModule mockIOModule;

    @Mock
    ListBooksAction listBooksAction;

    @Mock
    QuitAction quitAction;

    private App bibliotecaApp;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
        bibliotecaApp = new App(mockLibrary, mockIOModule, mockMenu);
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() {
        when(mockIOModule.readInput()).thenReturn("4");
        when(mockMenu.chooseOption(4)).thenReturn(quitAction);
        bibliotecaApp.start();

        verify(mockIOModule, times(1)).println(WELCOME_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPeformAnActionBasedOnUserInput() {
        when(mockIOModule.readInput()).thenReturn("4");
        when(mockMenu.chooseOption(4)).thenReturn(quitAction);
        bibliotecaApp.start();

        verify(mockMenu, times(1)).chooseOption(4);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(System.in);
    }
}
