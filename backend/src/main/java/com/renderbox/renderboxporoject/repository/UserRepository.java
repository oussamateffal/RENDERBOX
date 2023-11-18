package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public List<User> getByRole(String role);
    public User findByResetPasswordToken(String token);
}
