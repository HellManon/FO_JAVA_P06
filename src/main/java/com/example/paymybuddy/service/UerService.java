package com.example.paymybuddy.service;

import com.example.paymybuddy.dto.UserDTO;
import com.example.paymybuddy.model.User;

public interface UerService {
   void saveUser(UserDTO userDTO);

   User findUserByEmail(String email);
}
