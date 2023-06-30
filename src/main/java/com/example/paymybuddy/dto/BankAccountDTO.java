package com.example.paymybuddy.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {

    private Long id;

    private String iban;

    private String bank;
}
