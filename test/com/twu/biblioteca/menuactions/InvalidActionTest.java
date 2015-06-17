package com.twu.biblioteca.menuactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_SELECTION_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InvalidActionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPrintInvalidMessageWhenUserProvidesAnUnkonownOption() {
        InvalidAction invalidAction = new InvalidAction();
        invalidAction.execute();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is(INVALID_SELECTION_MESSAGE + "\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
