package org.example.matrixspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.security.JwtService;
import org.example.matrixspring.service.MyUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final MyUserService userService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails user = userService.loadUserByUsername(username);

        return jwtService.generateToken(user);
    }
}
