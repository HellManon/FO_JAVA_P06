package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.TransactionDto;

import java.util.List;

public interface AccountService {

    void addUserToFriendList(Long userId, Long friendId);
    void removeUserFromFriendList(Long userId, Long friendId);

    List<TransactionDto> getUserTransactions(Long userId);
}
