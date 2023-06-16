package com.example.paymybuddy.controller;

import com.example.paymybuddy.dto.UserDTO;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.service.UerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @Autowired
    private UerService uerService;

    @PostMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/registration")
    public String registrationForm (Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration (@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
        User existingUser = uerService.findUserByEmail(userDTO.getEmail());

        if (existingUser != null)
            result.rejectValue("email", null, "L'utilisateur est déjà enregistré !!!");

        if (result.hasErrors()) {
            model.addAttribute("user", userDTO);
            return "/registration";
        }
        uerService.saveUser(userDTO);
        return "redirect:/registration?success";
    }

}
