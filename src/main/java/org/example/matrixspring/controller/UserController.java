package org.example.matrixspring.controller;

import lombok.AllArgsConstructor;
import org.example.matrixspring.service.MyUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final MyUserService myUserService;

    @GetMapping
    public String test() {
        return "USER authenticated successfully!";
    }

    @GetMapping("/users/{username}")
    public UserDetails users(@PathVariable String username) {
        return myUserService.loadUserByUsername(username);
    }
}
