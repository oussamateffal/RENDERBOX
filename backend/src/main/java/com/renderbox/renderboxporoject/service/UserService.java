package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.entity.UserRole;

import java.util.List;

public interface UserService {

    User addNewUser(String email, String password, String confirmPassword, UserRole role);
    void addRoleToUser(String email, UserRole role);
    User loadUserByEmail(String email);
    List<User> getSupportMembers();
    public void updateResetPasswordToken(String token, String email);
    public User getByResetPasswordToken(String resetPasswordToken);
    public void updatePassword(User user, String newPassword);
    public User getUserById(Long id);
    public User save(User user);
    public User getByChatToken(String chatToken);
}
