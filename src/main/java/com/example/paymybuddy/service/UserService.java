package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.UserDto;
import com.example.paymybuddy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    long saveUser(UserDto userDto);

    User findUserByEmail(String email);

    abstract List<UserDto> findAllUsers();

    Optional<User> findById(long id);

    List<User> findAll();

    void deleteById(long id);
    void deleteByEmail(String email);
}
