package com.example.paymybuddy.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user;

    @Column(nullable = false)
    private int transaction_number;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int buddy_id;

    @Column(nullable = false)
    private Boolean done;

    public Transaction(int transaction_number, String description, String amount, Date date, int buddy_id, Boolean done) {
        this.transaction_number = transaction_number;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.buddy_id = buddy_id;
        this.done = done;
    }

}
