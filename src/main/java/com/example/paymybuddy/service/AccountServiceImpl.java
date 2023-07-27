package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.TransactionDto;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankAccountRepository;
import com.example.paymybuddy.repository.TransactionRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository, BankAccountRepository bankAccountRepository,
                              TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void addUserToFriendList(Long userId, Long friendId) {
        User user = userRepository.findById(userId).orElse(null);
        User friend = userRepository.findById(friendId).orElse(null);
        if (user != null && friend != null) {
            user.getFriends().add(friend);
            friend.getFriends().add(user);
        }
    }

    private TransactionDto mapToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setTransactionNumber(transaction.getTransaction_number());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setDone(transaction.getDone());
        return transactionDto;
    }
    @Override
    public void removeUserFromFriendList(Long userId, Long friendId) {
        User user = userRepository.findById(userId).orElse(null);
        User friend = userRepository.findById(friendId).orElse(null);
        if (user != null && friend != null) {
            user.getFriends().remove(friend);
            friend.getFriends().remove(user);
        }

    }

        @Override
        public List<TransactionDto> getUserTransactions(Long userId) {
            User user = userRepository.findById(userId).orElse(null);
            if (user == null) {
                return new ArrayList<>();
            }

            List<Transaction> transactions = transactionRepository.findAllByUser(user);
            return transactions.stream()
                    .map(this::mapToTransactionDto)
                    .collect(Collectors.toList());
        }
}
