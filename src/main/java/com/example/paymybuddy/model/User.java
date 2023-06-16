package com.example.paymybuddy.model;


import jakarta.persistence.*;

import lombok.Data;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String first_Name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean remember_me;

    private String iban;

    private String bank;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();

    public User(String last_name, String first_Name, String email, String password,Boolean remember_me, String iban,String bank, List<Role> roles) {
        this.last_name = last_name;
        this.first_Name = first_Name;
        this.email = email;
        this.password = password;
        this.remember_me = remember_me;
        this.iban = iban;
        this.bank = bank;
        this.roles = roles;
    }

    public User() {

    }

}

