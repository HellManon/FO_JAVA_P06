package com.example.paymybuddy.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendDto {

    private Long id;

    private String name;

    private String email;
}
