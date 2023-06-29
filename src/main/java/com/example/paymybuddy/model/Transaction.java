package com.example.paymybuddy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int transaction_number;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Long buddy_id;

    @Column(nullable = false)
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Transaction(int transaction_number, String description, String amount, LocalDate date, Long buddy_id, Boolean done) {
        this.transaction_number = transaction_number;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.buddy_id = buddy_id;
        this.done = done;
    }

}
