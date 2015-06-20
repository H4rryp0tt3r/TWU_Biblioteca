package com.twu.biblioteca;

import org.junit.Test;

import static com.twu.biblioteca.BibliotecaAppConstants.MEMBER_LOGIN_STATUS_MESSAGE;
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

    @Test
    public void shouldFollowTransitiveProperty() {
        Member firstMember = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        Member secondMember = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        Member thirdMember = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        assertEquals(firstMember, secondMember);
        assertEquals(secondMember, thirdMember);
        assertEquals(firstMember, thirdMember);
    }

    @Test
    public void shouldBeAbleToPrintStatusMessage() {
        Member member = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        String actualMessage = member.statusMessage();
        
        assertThat(actualMessage, is(MEMBER_LOGIN_STATUS_MESSAGE));
    }
}
