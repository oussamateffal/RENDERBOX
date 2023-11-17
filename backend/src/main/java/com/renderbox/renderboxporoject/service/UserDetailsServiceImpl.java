package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.loadUserByEmail(email);
        if(user == null) throw new UsernameNotFoundException(String.format("User %s not found", email));
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(user.getPassword())
                .roles(Arrays.toString(new com.renderbox.renderboxporoject.entity.UserRole[]{user.getRole()}))
                .build();
        return userDetails;
    }
}
