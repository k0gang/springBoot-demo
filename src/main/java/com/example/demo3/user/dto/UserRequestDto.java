package com.example.demo3.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRequestDto {

    private String userName;
    private String password;
    private String firstName;
    private String email;
}
