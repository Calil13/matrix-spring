package org.example.matrixspring.service;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.example.matrixspring.dao.entity.RoleEntity;
import org.example.matrixspring.dao.entity.UserEntity;
import org.example.matrixspring.dao.repository.UserRepository;
import org.example.matrixspring.exception.AlreadyExistsException;
import org.example.matrixspring.model.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new AlreadyExistsException("This user already exists!");
        }

        var userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        var role = new RoleEntity();
        role.setName("ROLE_USER");
        role.setUser(userEntity);

        var roles = new ArrayList<RoleEntity>();
        roles.add(role);
        userEntity.setRole(roles);

        userRepository.save(userEntity);
    }
}
