package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;           // 
    private String fullName;    // 
    private String email;       // 
    private User.Role role;     // 
    private Instant createdAt;  // 

    // Constructor to map from User Entity
    public UserDTO(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
    }
}