package com.example.demo3.user.domain;

import com.example.demo3.user.dto.UserResponseDto;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // 1. Query creation Method
    // SELECT * FROM users WHERE user_name=(1) AND password=(2)
    public User findByUserNameAndPassword(String userName, String password);

    public List<User> findByEmailIsNull();

    public List<User> findByFirstNameNot(String firstName);

    public List<User> findByFirstNameEndingWith(String suffix);

    public List<User> findByCodeGreaterThanEqual(int code);

    public List<User> findByFirstNameStartingWith(String prefix);

    // 2. Native query
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE user_name=?1 AND password=?2")
    public User test(@Param("userName") String userName, @Param("password") String password);

}
