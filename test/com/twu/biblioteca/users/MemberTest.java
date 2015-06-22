package com.twu.biblioteca.users;

import com.twu.biblioteca.controllers.Selector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.BibliotecaAppConstants.MEMBER_LOGIN_STATUS_MESSAGE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberTest {

    @Mock
    Member mockMember;

    @Mock
    Selector mockSelector;

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

    @Test
    public void shouldBeAbleToPrintBasicDetails() {
        when(mockMember.getUserBasicDetails()).thenReturn("| 123-4567 : Nagesh |");

        String actualDetails = mockMember.getUserBasicDetails();

        assertThat(actualDetails, is("| 123-4567 : Nagesh |"));
    }

    @Test
    public void shouldBeAbleToPrintFullDetails() {
        Member member = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        String actualDetails = member.toString();

        assertThat(actualDetails, is("| Library Number : 111-1111 |\n| Full Name : Nagesh |\n" +
                "| Email Address : nagesh@gmail.com |\n| Phone Number : 1234567890|\n"));
    }

    @Test
    public void shouldBeAbleToReturnTrueOnValidCredentialsVerification() {
        Member member = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");

        boolean actualResult = member.verifyCredentials("111-1111", "s3cr3t");

        assertThat(actualResult, is(true));
    }

    @Test
    public void shouldBeAbleToAcceptMenuSelector() {
        Member member = new Member("111-1111", "s3cr3t", "Nagesh", "nagesh@gmail.com", "1234567890");
        member.acceptSelector(mockSelector);

        verify(mockSelector).selectAppropriateMenu(member);
    }
}
