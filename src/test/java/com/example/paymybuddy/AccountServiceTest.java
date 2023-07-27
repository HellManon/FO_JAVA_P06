package com.example.paymybuddy;


import com.example.paymybuddy.dto.TransactionDto;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankAccountRepository;
import com.example.paymybuddy.repository.TransactionRepository;
import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class AccountServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUserToFriendList() {
        Long userId = 1L;
        Long friendId = 2L;

        User user = new User();
        user.setId(userId);

        User friend = new User();
        friend.setId(friendId);

        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(user));
        when(userRepository.findById(friendId)).thenReturn(java.util.Optional.of(friend));

        accountService.addUserToFriendList(userId, friendId);

        assertEquals(1, user.getFriends().size());
        assertEquals(1, friend.getFriends().size());
        assertEquals(friend, user.getFriends().get(0));
        assertEquals(user, friend.getFriends().get(0));
    }

    @Test
    public void testRemoveUserFromFriendList() {
        Long userId = 1L;
        Long friendId = 2L;

        User user = new User();
        user.setId(userId);

        User friend = new User();
        friend.setId(friendId);

        user.getFriends().add(friend);
        friend.getFriends().add(user);

        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(user));
        when(userRepository.findById(friendId)).thenReturn(java.util.Optional.of(friend));

        accountService.removeUserFromFriendList(userId, friendId);

        assertEquals(0, user.getFriends().size());
        assertEquals(0, friend.getFriends().size());
    }

    @Test
    public void testGetUserTransactions() {
        Long userId = 1L;

        User user = new User();
        user.setId(userId);

        Transaction transaction1 = new Transaction();
        transaction1.setId(1L);

        Transaction transaction2 = new Transaction();
        transaction2.setId(2L);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(user));
        when(transactionRepository.findAllByUser(user)).thenReturn(transactions);

        List<TransactionDto> transactionDtos = accountService.getUserTransactions(userId);

        assertEquals(2, transactionDtos.size());
        assertEquals(1L, transactionDtos.get(0).getId());
        assertEquals(2L, transactionDtos.get(1).getId());
    }
}
