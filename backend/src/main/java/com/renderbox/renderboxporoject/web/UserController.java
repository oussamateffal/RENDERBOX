package com.renderbox.renderboxporoject.web;

import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.entity.UserRole;
import com.renderbox.renderboxporoject.repository.UserRepository;
import com.renderbox.renderboxporoject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user.getRole() == UserRole.ROLE_USER) {
            // Affectez un rôle par défaut (ROLE_USER) et n'exigez pas de mot de passe
            user.setRole(UserRole.ROLE_USER);
            userRepository.save(user);
        } else {
            // Vérifiez que le mot de passe est fourni pour les membres de support et les administrateurs
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                return ResponseEntity.badRequest().body("Password is required.");
            }

            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }

        return ResponseEntity.ok("User registered successfully.");
    }
}

