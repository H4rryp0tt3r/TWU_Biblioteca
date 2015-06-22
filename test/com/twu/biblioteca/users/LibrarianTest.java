package com.twu.biblioteca.users;

import com.twu.biblioteca.controllers.Selector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.LIBRARIAN_LOGIN_STATUS_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibrarianTest {

    @Mock
    Librarian mockLibrarian;

    @Mock
    Selector mockSelector;

    @Test
    public void shouldFollowSymmetryProperty() {
        Librarian firstLibrarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        Librarian secondLibrarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        assertThat(firstLibrarian, is(secondLibrarian));
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Librarian firstLibrarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        Librarian secondLibrarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        Librarian thirdLibrarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        assertEquals(firstLibrarian, secondLibrarian);
        assertEquals(secondLibrarian, thirdLibrarian);
        assertEquals(firstLibrarian, thirdLibrarian);
    }

    @Test
    public void shouldBeAbleToPrintStatusMessage() {
        Librarian librarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        String actualMessage = librarian.statusMessage();

        assertThat(actualMessage, is(LIBRARIAN_LOGIN_STATUS_MESSAGE));
    }

    @Test
    public void shouldBeAbleToPrintBasicDetails() {
        when(mockLibrarian.getUserBasicDetails()).thenReturn("| 123-4567 : Nagesh |");

        String actualDetails = mockLibrarian.getUserBasicDetails();

        assertThat(actualDetails, is("| 123-4567 : Nagesh |"));
    }

    @Test
    public void shouldBeAbleToPrintFullDetails() {
        Librarian librarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        String actualDetails = librarian.toString();

        assertThat(actualDetails, is("| Library Number : 111-1111 |\n| Full Name : Nagesh |\n" +
                "| Email Address : nagesh@gmail.com |\n| Phone Number : 1234567890|\n"));
    }

    @Test
    public void shouldBeAbleToReturnTrueOnValidCredentialsVerification() {
        Librarian librarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        boolean actualResult = librarian.verifyCredentials("111-1111", "s3cr3t");

        assertThat(actualResult, is(true));
    }

    @Test
    public void shouldBeAbleToAcceptMenuSelector() {
        Librarian librarian = new Librarian("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        librarian.acceptSelector(mockSelector);

        verify(mockSelector).selectAppropriateMenu(librarian);
    }
}
