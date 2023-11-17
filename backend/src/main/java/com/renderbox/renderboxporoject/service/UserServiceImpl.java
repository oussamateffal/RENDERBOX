package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.entity.UserRole;
import com.renderbox.renderboxporoject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User addNewUser(String email, String password, String confirmPassword, String role) {
        User user = userRepository.findByEmail(email);
        if(user != null) throw new RuntimeException("This email already exist");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Passwords not match exist");
        User createdUser = user.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        User savedUser = userRepository.save(createdUser);
        return savedUser;
    }

    @Override
    public void addRoleToUser(String email, UserRole role) {
        User user = userRepository.findByEmail(email);
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getSupportMembers() {
        List<User> supportMembers = userRepository.getByRole("ROLE_SUPPORT");
        return supportMembers;
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format("Could not found any User with email %s", email));
        }
    }

    @Override
    public User getByResetPasswordToken(String resetPasswordToken) {
        return userRepository.findByResetPasswordToken(resetPasswordToken);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
}
