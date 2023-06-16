package com.example.paymybuddy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bankAccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false)
    private String iban;

    @Column(nullable = false)
    private String bank;

    public BankAccount (String iban, String bank) {
        this.iban = iban;
        this.bank = bank;
    }
}
