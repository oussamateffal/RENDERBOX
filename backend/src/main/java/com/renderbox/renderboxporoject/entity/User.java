package com.renderbox.renderboxporoject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private String password;
    private boolean blocked;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name="reset_password_token")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String resetPasswordToken;

    @Column(name="chat_token")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String chatToken;

    @ManyToMany(mappedBy = "users")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<ChatRoom> chatRooms = new HashSet<>();
}

