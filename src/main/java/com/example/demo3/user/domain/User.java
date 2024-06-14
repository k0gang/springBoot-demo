package com.example.demo3.user.domain;

import com.example.demo3.user.dto.UserRequestDto;
import com.example.demo3.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor  // 기본생성자 자동으로 생성
@Getter
@Table(name = "users")
@Entity
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String userName;
    private String password;
    private String firstName;
    private String email;


    public void update(UserRequestDto userRequestDto){
        // 선택적으로 수정하는 멤버를 선택
        if(userRequestDto.getUserName() != null){
            this.userName = userRequestDto.getUserName();
        }
        if(userRequestDto.getPassword() != null){
            this.password = userRequestDto.getPassword();
        }
        if(userRequestDto.getFirstName() != null){
            this.firstName = userRequestDto.getFirstName();
        }
        if(userRequestDto.getEmail() != null){
            this.email = userRequestDto.getEmail();
        }
    }
}