package com.example.paymybuddy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class LoginController {

    @RolesAllowed("USER")
    @RequestMapping("/*")
    public String getUser(){
        return "Welcome, User";
    }

    @RolesAllowed("ADMIN")
    @RequestMapping("/admin")
    public String getAdmin() {
        return "Welcome, Admin";
    }
}
