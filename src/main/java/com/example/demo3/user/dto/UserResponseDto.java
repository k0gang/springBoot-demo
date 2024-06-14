package com.example.demo3.user.dto;

import com.example.demo3.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private int code;
    private String userName;
    private String password;
    private String firstName;
    private String email;
    private Timestamp regDate;
    private Timestamp modDate;

    public UserResponseDto(User user){
        this.code = user.getCode();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.email = user.getEmail();
        this.regDate = user.getRegDate();
        this.modDate = user.getModDate();
    }
}