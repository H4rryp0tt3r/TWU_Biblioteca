package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_CREDENTIALS_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GuestTest {
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
}
