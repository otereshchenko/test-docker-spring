package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloController {
    private final UserService userService;

    @GetMapping
    public Map<String, List<UserDto>> helloMessage() {
        List<UserDto> users = userService.getUsers();
        return Map.of("Hello", users);
    }

    @GetMapping("/{user-name}")
    public Map<String, UserDto> helloMessage(@PathVariable("user-name") String userName) {
        UserDto newUser = userService.saveUser(userName);
        return Map.of("Hello new user ", newUser);
    }
}
