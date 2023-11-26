package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Simulated user data (replace this with your data from a database)
    private static List<User> users = new ArrayList<>();

    static {
        // Passwords should be encoded using a PasswordEncoder in a real application
        users.add(new User(1L, "john.doe@example.com", "password", false, UserRole.ROLE_USER, null, null, null));
        users.add(new User(2L, "admin@example.com", "adminpassword", false, UserRole.ROLE_ADMIN, null, null, null));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + email));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .authorities(authorities)
                .build();
    }
}


