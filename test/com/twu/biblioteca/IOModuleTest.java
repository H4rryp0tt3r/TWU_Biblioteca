package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IOModuleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("2".getBytes());


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
    }

    @Test
    public void shouldBeAbleToPrintGivenMessage() {
        IOModule ioModule = new IOModule(new Scanner(System.in), new PrintWriter(System.out, true));
        ioModule.print("Hello");

        String actualMessage = outContent.toString();

        assertThat(actualMessage, is("Hello\n"));
    }

    @Test
    public void shouldBeAbleToReadInputFromUser() {
        Scanner mockScanner = new Scanner(inContent);
        IOModule ioModule = new IOModule(mockScanner, new PrintWriter(System.out, true));

        String actualInput = ioModule.readInput();

        assertThat(actualInput, is("2"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }
}
