package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Simulated user data (replace this with your data from a database)
    private static List<User> users = new ArrayList<>();

    static {
        // Passwords should be encoded using a PasswordEncoder in a real application
        users.add(new User("john.doe@example.com", "password", Collections.singletonList("ROLE_USER")));
        users.add(new User("admin@example.com", "adminpassword", Collections.singletonList("ROLE_ADMIN")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRoles()))
                .build();
    }
}

