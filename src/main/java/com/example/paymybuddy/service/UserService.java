package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.UserDto;
import com.example.paymybuddy.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    abstract List<UserDto> findAllUsers();
}
