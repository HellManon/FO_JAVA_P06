package com.example.paymybuddy.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {

    private Long userId;
    private double amount;
    private String destinationIban;
    private String destinationBank;
}
