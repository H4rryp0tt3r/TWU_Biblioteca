package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaAppConstants.INVALID_CREDENTIALS_MESSAGE;
import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARIAN_LOGIN_STATUS_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibrarianTest {
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
}
