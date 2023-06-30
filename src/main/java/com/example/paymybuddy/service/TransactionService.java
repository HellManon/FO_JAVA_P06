package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.BankAccountDto;
import com.example.paymybuddy.dto.TransactionDto;

public interface TransactionService {

    void depositMoney(Long userId, double amount);

    void makePayment(TransactionDto transactionDto);

    void transferToBankAccount(TransferDto transferDto);

    BankAccountDto getUserBankAccount(Long userId);
}
