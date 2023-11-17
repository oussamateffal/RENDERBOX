package com.renderbox.renderboxporoject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private boolean blocked;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name="reset_password_token")
    private String resetPasswordToken;

}

