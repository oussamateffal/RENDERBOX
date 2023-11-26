package com.renderbox.renderboxporoject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @Column(name="chat_token")
    private String chatToken;

    @ManyToMany(mappedBy = "users")
    private Set<ChatRoom> chatRooms = new HashSet<>();
}

