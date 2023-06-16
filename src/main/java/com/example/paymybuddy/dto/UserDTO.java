package com.example.paymybuddy.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class UserDTO {

    private Long id;

    @NotEmpty(message = "Entrer un nom valide")
    private String name;

    @NotEmpty(message = "Entrer un email valide")
    private String email;

    @NotEmpty(message = "Entrer un mot de pass valide")
    private String password;

  /*
    public UserDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

    public UserDTO() {

    }

   */
}
