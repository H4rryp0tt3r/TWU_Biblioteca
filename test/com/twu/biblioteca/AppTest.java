package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());

    @Mock
    Menu mockMenu;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
    }

    @Test
    public void shouldBeAbleToExecuteActionsBasedOnUserChoice() {

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }
}
