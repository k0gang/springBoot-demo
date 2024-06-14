package com.example.demo3.user.controller;

import com.example.demo3.user.domain.User;
import com.example.demo3.user.domain.UserService;
import com.example.demo3.user.dto.UserRequestDto;
import com.example.demo3.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ResponseBody
    @GetMapping("/test")
    public List<User> test(){
        List<User> list = new ArrayList<User>();
        list = userService.findAll();
        return list;
    }

    // userName 과 password를 requestBody로 담아 요청을 하면
    // user Object 가 JSON 으로  응답 되는 메소드
    @ResponseBody
    @GetMapping("/test1")
    public UserResponseDto test1(@RequestBody UserRequestDto userRequestDto){
        String id = userRequestDto.getUserName();
        String password = userRequestDto.getPassword();

        return userService.findUserByIdAndPassword(id, password);
    }

    @ResponseBody
    @GetMapping("/test2")
    public List<User> test2() {
        List<User> list = new ArrayList<>();
        list = userService.findByEmailIsNull();
        return list;
    }

    @ResponseBody
    @GetMapping("/test3")
    public List<User> test3(@RequestBody UserRequestDto userRequestDto) {
        List<User> list = new ArrayList<>();
        list = userService.findByFirstNameNot(userRequestDto.getFirstName());
        return list;
    }

    @ResponseBody
    @GetMapping("/test4")
    public List<User> test4(@RequestParam String suffix) {
        List<User> list = new ArrayList<>();
        list = userService.findByFirstNameEndingWith(suffix);
        return list;
    }

    @ResponseBody
    @GetMapping("/test5")
    public List<User> test5(@RequestParam int code) {
        List<User> list = new ArrayList<>();
        list = userService.findByCodeGreaterThanEqual(code);
        return list;
    }

    @ResponseBody
    @GetMapping("/test6")
    public List<User> test6(@RequestParam String prefix) {
        System.out.println(prefix);
        List<User> list = new ArrayList<>();
        list = userService.findByFirstNameStartingWith(prefix);
        return list;
    }

    @ResponseBody
    @GetMapping("/test7")
    public User test7(@RequestBody UserRequestDto userRequestDto){
        String id = userRequestDto.getUserName();
        String password = userRequestDto.getPassword();
        User user = new User();
        user = userService.test(id, password);
        return user;
    }

    // GET   /users              전체 회원 정보 응답                                findAll()
    // GET   /user/{userCode}    회원 한명 정보 응답                                findUserById()
    // GET   /user               회원 한명 정보 응답 (username and password로 조회)  내가 만든 메소드 (test)

    // POST     /user               회원 정보 추가 (request body로 정보 전달)        save()
    // PUT      /user/{userCode}    회원 정보 수정 (request body로 정보 전달)        pk로 조회하여 얻어온 User 객체의 정보를 setter 호출을 통해 수정
    // DELETE   /user/{userCode}    회원 정보 삭제                                 deleteById()

    @RequestMapping("/join")
    public ModelAndView join(){
        ModelAndView mv = new ModelAndView("user/join");

        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("user/login");
        return mv;
    }

    @PostMapping("")
    public ModelAndView join(@ModelAttribute UserRequestDto userRequestDto){

        User user = new User();
        user.update(userRequestDto);
        UserResponseDto save = userService.save(user);

        if(save != null){
            System.out.println("성공");
            ModelAndView mv = new ModelAndView("user/login");
            return mv;
        }else{
            System.out.println("실패");
            ModelAndView mv = new ModelAndView("user/join");
            return mv;
        }
    }

    @PostMapping("/loginAction")
    public ModelAndView loginAction(@ModelAttribute UserRequestDto userRequestDto){
        String id = userRequestDto.getUserName();
        String password = userRequestDto.getPassword();
        UserResponseDto userByIdAndPassword = userService.findUserByIdAndPassword(id, password);

        if(userByIdAndPassword != null){
            System.out.println("로그인 성공");
            ModelAndView mv = new ModelAndView("user/join");
            return mv;
        }else {
            System.out.println("로그인 실패");
            ModelAndView mv = new ModelAndView("user/login");
            return mv;
        }
    }


}
