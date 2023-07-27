package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.BankAccountDto;
import com.example.paymybuddy.dto.TransactionDto;
import com.example.paymybuddy.model.BankAccount;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankAccountRepository;
import com.example.paymybuddy.repository.TransactionRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(UserRepository userRepository, BankAccountRepository bankAccountRepository,
                                  TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void depositMoney(Long userId, double amount) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            // Update the user's bank balance by adding the deposited amount
            String bankBalance = user.getBankBalance();
            double currentBalance = Double.parseDouble(bankBalance);
            double newBalance = currentBalance + amount;
            user.setBankBalance(String.valueOf(newBalance));
            userRepository.save(user);
        }
    }

    @Override
    public void makePayment(TransactionDto transactionDto) {
        User user = userRepository.findById(transactionDto.getUserId()).orElse(null);
        if (user != null) {
            // Create a new transaction for the payment
            Transaction transaction = new Transaction();
            transaction.setDescription(transactionDto.getDescription());
            transaction.setAmount(transactionDto.getAmount());
            transaction.setDate(transactionDto.getDate());
            transaction.setDone(true);
            transaction.setUser(user);
            transactionRepository.save(transaction);
        }
    }

    @Override
    public void transferToBankAccount(TransactionDto transferDto) {
        User user = userRepository.findById(transferDto.getUserId()).orElse(null);
        BankAccount bankAccount = bankAccountRepository.findById(transferDto.getBankAccountId()).orElse(null);
        if (user != null && bankAccount != null) {
            // Create a new transaction for the transfer
            Transaction transaction = new Transaction();
            transaction.setDescription(transferDto.getDescription());
            transaction.setAmount(transferDto.getAmount());
            transaction.setDate(transferDto.getDate());
            transaction.setDone(true);
            transaction.setUser(user);
            transactionRepository.save(transaction);
        }
    }

    @Override
    public BankAccountDto getUserBankAccount(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            // Get the user's bank account details
            BankAccount bankAccount = user.getBankAccounts().stream().findFirst().orElse(null);
            if (bankAccount != null) {
                BankAccountDto bankAccountDto = new BankAccountDto();
                bankAccountDto.setIban(bankAccount.getIban());
                bankAccountDto.setBank(bankAccount.getBank());
                return bankAccountDto;
            }
        }
        return null;
    }
}
