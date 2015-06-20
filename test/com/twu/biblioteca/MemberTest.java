package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaAppConstants.LIBRARIAN_LOGIN_STATUS_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MemberTest {
    @Test
    public void shouldFollowSymmetryProperty() {
        Member firstMember = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        Member secondMember = new Member("123-4567", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
    
        assertThat(firstMember, is(secondMember));
    }
}
