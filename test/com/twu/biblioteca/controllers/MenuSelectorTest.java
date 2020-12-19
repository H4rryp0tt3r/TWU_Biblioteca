package com.twu.biblioteca.controllers;

import com.twu.biblioteca.menuactions.LogOutAction;
import com.twu.biblioteca.menuactions.LoginAction;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.users.Guest;
import com.twu.biblioteca.users.Librarian;
import com.twu.biblioteca.users.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuSelectorTest {

    @Mock
    Guest mockGuest;

    @Mock
    Member mockMember;

    @Mock
    Librarian mockLibrarian;

    @Mock
    Menu mockGuestMenu;

    @Mock
    Menu mockMemberMenu;

    @Mock
    Menu mockLibrarianMenu;

    @Mock
    LoginAction mockLoginAction;

    @Mock
    LogOutAction mockLogoutAction;

    @Test
    public void shouldBeAbleToChooseGuestMenu() {
        MenuSelector menuSelector = new MenuSelector(mockGuestMenu, mockMemberMenu, mockLibrarianMenu);
        when(mockGuestMenu.chooseOption()).thenReturn(mockLoginAction);
        menuSelector.selectAppropriateMenu(mockGuest);

        verify(mockGuestMenu).chooseOption();
    }

    @Test
    public void shouldBeAbleToChooseMemberMenu() {
        MenuSelector menuSelector = new MenuSelector(mockGuestMenu, mockMemberMenu, mockLibrarianMenu);
        when(mockMemberMenu.chooseOption()).thenReturn(mockLogoutAction);
        menuSelector.selectAppropriateMenu(mockMember);

        verify(mockMemberMenu).chooseOption();
    }

    @Test
    public void shouldBeAbleToChooseLibrarianMenu() {
        MenuSelector menuSelector = new MenuSelector(mockGuestMenu, mockMemberMenu, mockLibrarianMenu);
        when(mockLibrarianMenu.chooseOption()).thenReturn(mockLogoutAction);
        menuSelector.selectAppropriateMenu(mockLibrarian);

        verify(mockLibrarianMenu).chooseOption();
    }
}