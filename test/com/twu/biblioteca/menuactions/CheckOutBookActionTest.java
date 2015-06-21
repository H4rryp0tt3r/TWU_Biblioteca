package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookActionTest {
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("Sample Book1\n".getBytes());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Section bookSection;
    private IOModule ioModule;
    private Controller controller;

    @Mock
    LoginAction mockLoginAction;

    @Before
    public void setUp() {
        List<LibraryItem> availableBooksList = new ArrayList<>();
        List<LibraryItem> checkedOutBooksList = new ArrayList<>();
        List<LibraryItem> searchResultsList = new ArrayList<>();
        availableBooksList.add(new Book("Sample Book1", "Nagesh", "2009"));
        availableBooksList.add(new Book("Sample Book2", "Naresh", "2010"));
        availableBooksList.add(new Book("Sample Book3", "Ganesh", "2011"));
        ioModule = new IOModule(new Scanner(new BufferedInputStream(inContent)), new PrintStream(outContent));
        bookSection = new Section(availableBooksList, checkedOutBooksList, searchResultsList);
        controller = new Controller(ioModule);
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToPerformCheckOutAction() throws IOException {
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(bookSection, controller, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE, mockLoginAction);
        checkOutBookAction.execute();

        String actualStatusMessage = outContent.toString();

        assertThat(actualStatusMessage, is(NAME_PROMPT_MESSAGE + SUCCESSFUL_BOOK_CHECKOUT_MESSAGE + "\n"));
    }

    @After
    public void cleanUp() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }
}
