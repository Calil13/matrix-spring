package org.example.matrixspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.model.UserDto;
import org.example.matrixspring.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/makeAdmin/{username}")
    public String makeAdmin(@PathVariable String username) {
        return adminService.makeAdmin(username);
    }
}

