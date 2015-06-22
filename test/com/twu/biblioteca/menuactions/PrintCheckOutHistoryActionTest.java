package com.twu.biblioteca.menuactions;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.IOModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrintCheckOutHistoryActionTest {

    @Mock
    Section mockBookSection;

    @Mock
    Section mockMovieSection;

    @Mock
    IOModule mockIOModule;

    @Test
    public void shouldBeAbleToDisplayCheckedOutBookHistory() {
        PrintCheckOutHistoryAction printCheckOutHistoryAction = new PrintCheckOutHistoryAction(mockBookSection, mockMovieSection, mockIOModule);
        when(mockBookSection.displayCheckedOutItemDetails()).thenReturn("details");
        printCheckOutHistoryAction.execute();

        verify(mockIOModule).println("details");
    }

    @Test
    public void shouldBeAbleToDisplayCheckOutMoviesHistory() {
        PrintCheckOutHistoryAction printCheckOutHistoryAction = new PrintCheckOutHistoryAction(mockBookSection, mockMovieSection, mockIOModule);
        when(mockMovieSection.displayCheckedOutItemDetails()).thenReturn("details");
        printCheckOutHistoryAction.execute();

        verify(mockIOModule).println("details");
    }
}
