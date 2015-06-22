package com.twu.biblioteca.users;

import com.twu.biblioteca.controllers.Selector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.INVALID_CREDENTIALS_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuestTest {

    @Mock
    Guest mockGuest;

    @Mock
    Selector mockSelector;

    @Test
    public void shouldFollowSymmetryProperty() {
        Guest firstGuest = new Guest();

        Guest secondGuest = new Guest();

        assertThat(firstGuest, is(secondGuest));
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Guest firstGuest = new Guest();
        Guest secondGuest = new Guest();
        Guest thirdGuest = new Guest();

        assertEquals(firstGuest, secondGuest);
        assertEquals(secondGuest, thirdGuest);
        assertEquals(firstGuest, thirdGuest);
    }

    @Test
    public void shouldBeAbleToPrintStatusMessage() {
        Guest guestUser = new Guest();

        String actualMessage = guestUser.statusMessage();

        assertThat(actualMessage, is(INVALID_CREDENTIALS_MESSAGE));
    }

    @Test
    public void shoudlBeAbleToCreateANewGuest() {
        Guest actualCreatedGuest = Guest.create();

        assertThat(actualCreatedGuest, is(new Guest()));
    }


    @Test
    public void shouldBeAbleToPrintBasicDetails() {
        when(mockGuest.getUserBasicDetails()).thenReturn("| 123-4567 : Nagesh |");

        String actualDetails = mockGuest.getUserBasicDetails();

        assertThat(actualDetails, is("| 123-4567 : Nagesh |"));
    }

    @Test
    public void shouldBeAbleToPrintFullDetails() {
        Guest guest = new Guest();

        String actualDetails = guest.toString();

        assertThat(actualDetails, is("| Library Number :  |\n| Full Name :  |\n| Email Address :  |\n| Phone Number : |\n"));
    }

    @Test
    public void shouldBeAbleToReturnTrueOnValidCredentialsVerification() {
        Guest guest = new Guest();
        boolean actualResult = guest.verifyCredentials("111-1111", "s3cr3t");

        assertThat(actualResult, is(false));
    }

    @Test
    public void shouldBeAbleToAcceptMenuSelector() {
        Guest guest = new Guest();
        guest.acceptSelector(mockSelector);

        verify(mockSelector).selectAppropriateMenu(guest);
    }
}
