package org.example.matrixspring.service;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.dao.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

        var roles = userEntity.getRole().stream().map(
                roleEntity -> new SimpleGrantedAuthority(roleEntity.getName()))
                .toList();

        return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
    }
}
