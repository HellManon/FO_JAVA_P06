package com.example.paymybuddy.service;

import com.example.paymybuddy.configuration.TbConstants;
import com.example.paymybuddy.dto.UserDTO;
import com.example.paymybuddy.model.Role;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.RolesRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UerServiceImpl implements UerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser (UserDTO userDTO) {
        Role role = rolesRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = rolesRepository.save(new Role(TbConstants.Roles.USER));

        User user = new User(userDTO.getName(), userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()),
                Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail (String email) {
        return userRepository.findByEmail(email);
    }

}

