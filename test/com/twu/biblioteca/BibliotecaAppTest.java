package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
    private final Library library = new Library();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp(library);
        app.printWelcomeMessage();

        String actualMessage = outContent.toString();

        assertThat(actualMessage, is("Welcome to Biblioteca!\n"));
    }

    @Test
    public void shouldBeAbleToDisplayMenuAndUserShouldBeAbleToChooseOne() throws IOException {
        BibliotecaApp app = new BibliotecaApp(library);
        app.displayMainMenu();
        inContent.read("1".getBytes());

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("==== Main Menu ====\n1) List Books\nEnter your Choice:\n"+
                                      "Sample Book1                                       | Nagesh          | 2009 \n" +
                                      "Sample Book2                                       | Naresh          | 2010 \n" +
                                      "Sample Book3                                       | Ganesh          | 2011 \n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }
}
