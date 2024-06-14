package com.example.demo3.user.domain;

import com.example.demo3.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public UserResponseDto findUserByIdAndPassword(String id, String password) {
        return new UserResponseDto(userRepository.findByUserNameAndPassword(id, password));
    }

    public List<User> findByEmailIsNull(){
        return userRepository.findByEmailIsNull();
    }

    public List<User> findByFirstNameNot(String firstName){
        return userRepository.findByFirstNameNot(firstName);
    }

    public List<User> findByFirstNameEndingWith(String suffix){
        return userRepository.findByFirstNameEndingWith(suffix);
    }

    public List<User> findByCodeGreaterThanEqual(int code){
        return userRepository.findByCodeGreaterThanEqual(code);
    }

    public List<User> findByFirstNameStartingWith(String prefix){
        return userRepository.findByFirstNameStartingWith(prefix);
    }

    public User test(String id, String password){
        return userRepository.test(id, password);
    }

    public User findUserByCode(int code){
        User user = userRepository.findById(code).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자입니다")
        );
        return user;
    }

    public UserResponseDto save(User user) {
        User save = userRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;
    }


}
