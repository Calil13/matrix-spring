package org.example.matrixspring.service;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.dao.entity.RoleEntity;
import org.example.matrixspring.dao.entity.UserEntity;
import org.example.matrixspring.dao.repository.RoleRepository;
import org.example.matrixspring.dao.repository.UserRepository;
import org.example.matrixspring.exception.NotFoundException;
import org.example.matrixspring.model.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public String makeAdmin(String username) {

        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found!"));

        boolean isAlreadyAdmin = user.getRole().stream()
                .anyMatch(r -> "ROLE_ADMIN".equals(r.getName()));

        if (isAlreadyAdmin) {
            return "This user is already ADMIN!";
        }

        var role = new RoleEntity();
        role.setName("ROLE_ADMIN");
        role.setUser(user);

        user.getRole().add(role);
        userRepository.save(user);

        return "User successfully upgraded to ADMIN!";
    }
}

