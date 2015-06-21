package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutHistoryTest {
    @Mock
    HashMap<User, LibraryItem> mockHistoryList;

    @Test
    public void shouldBeAbleToAddCheckOutHistory() {
        User member = new Member("111-1111", "password", "Nagesh", "nagesh@gmail.com", "9876543210");
        Book book = new Book("Book1", "Nagesh", "1995");
        CheckOutHistory checkOutHistory = new CheckOutHistory(mockHistoryList);

        checkOutHistory.addItemToHistory(book, member);

        verify(mockHistoryList).put(member, book);
    }
}
