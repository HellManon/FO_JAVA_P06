package com.example.paymybuddy.dto;

//import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "Entrer un nom valide")
    private String name;

    @NotEmpty(message = "Entrer un email valide")
    @Email
    private String email;

    @NotEmpty(message = "Entrer un mot de pass valide")
    private String password;

}
