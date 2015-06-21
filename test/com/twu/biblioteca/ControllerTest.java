package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaAppConstants.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Mock
    IOModule mockIOModule;
    @Mock
    Section mockSection;
    @Mock
    User user;
    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller(mockIOModule);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToListAvailableItemsWhenSectionIsPassedAsAnArgument() {
        when(mockSection.displayAvailableItemsWithAllDetails()).thenReturn("Sample Movies");
        controller.listAvailableItems(mockSection);

        verify(mockIOModule).println(mockSection.displayAvailableItemsWithAllDetails());
    }

    @Test
    public void shouldBeAbleToCheckOutAnItemFromCorrespondingSection() {
        when(mockIOModule.readInput()).thenReturn("Sample Book1");
        controller.checkOutAnItem(mockSection, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE, user);

        verify(mockSection).checkOut("Sample Book1", user);
    }

    @Test
    public void shoudlBeAbleToReturnAnItemToCorrespondingSection() {
        when(mockIOModule.readInput()).thenReturn("H4rryp0tt3r");
        controller.returnAnItem(mockSection, SUCCESSFUL_MOVIE_RETURN_MESSAGE, FAILED_MOVIE_RETURN_MESSAGE, user);

        verify(mockSection).returnItem("H4rryp0tt3r", user);
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}
