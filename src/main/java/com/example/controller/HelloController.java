package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public Map<String, String> helloMessage() {
        return Map.of("Hello", "John");
    }

    @GetMapping("/{user-name}")
    public Map<String, String> helloMessage(@PathVariable("user-name") String userName) {
        return Map.of("Hello", userName);
    }
}
