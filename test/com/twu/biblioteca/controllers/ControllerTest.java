package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.users.User;
import com.twu.biblioteca.views.IOModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

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

    @Test
    public void shouldBeAbleToPrintFailedStatusMessageUponAFailedReturn() {
        when(mockIOModule.readInput()).thenReturn("Sample");
        controller.returnAnItem(mockSection, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE, user);

        verify(mockIOModule).println(FAILED_BOOK_RETURN_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPrintFailedStatusMessageUponAFailedCheckOut() {
        when(mockIOModule.readInput()).thenReturn("Sample");
        controller.checkOutAnItem(mockSection, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE, user);

        verify(mockIOModule).println(FAILED_BOOK_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPrintSuccessStatusMessageUponASuccessfulReturn() {
        when(mockIOModule.readInput()).thenReturn("Sample Book1");
        when(mockSection.checkOut("Sample Book1", user)).thenReturn(true);
        when(mockSection.returnItem("Sample Book1", user)).thenReturn(true);
        controller.checkOutAnItem(mockSection, SUCCESSFUL_BOOK_CHECKOUT_MESSAGE, FAILED_BOOK_CHECKOUT_MESSAGE, user);
        controller.returnAnItem(mockSection, SUCCESSFUL_BOOK_RETURN_MESSAGE, FAILED_BOOK_RETURN_MESSAGE, user);

        verify(mockIOModule).println(SUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
        verify(mockIOModule).println(SUCCESSFUL_BOOK_RETURN_MESSAGE);
    }
}
