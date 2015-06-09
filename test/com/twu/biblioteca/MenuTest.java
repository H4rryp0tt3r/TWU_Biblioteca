package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final Library library = new Library();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPrintMenuInRequiredFormat() {
        Menu menu = new Menu(library);

        String actualMenu = menu.toString();

        assertThat(actualMenu, is("1) List Books\n2) Quit\n"));
    }

    @Test
    public void shouldBeAbleToPerformTheCorrectMenuActionOnUserChoice() {
        Menu menu = new Menu(library);

        String actualInvokedClass = menu.chooseOption(1).getClass().getName();

        assertThat(actualInvokedClass, is("com.twu.biblioteca.ListBooks"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
