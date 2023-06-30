package com.example.paymybuddy.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private int transactionNumber;
    private String description;
    private String amount;
    private LocalDate date;
    private Long buddyId;
    private boolean done;
}
