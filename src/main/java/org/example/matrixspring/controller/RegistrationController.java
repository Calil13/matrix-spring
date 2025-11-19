package org.example.matrixspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.model.UserDto;
import org.example.matrixspring.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public void registerUser(@RequestBody UserDto user) {
        registrationService.register(user);
    }
}
