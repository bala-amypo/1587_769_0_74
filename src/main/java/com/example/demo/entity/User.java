package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // Persisted as BCrypt hash

    private String role; // ADMIN / INSTRUCTOR / STUDENT

    @Builder.Default
    private Instant createdAt = Instant.now();

    @PrePersist
    public void prePersist() {
        if (this.role == null) {
            this.role = "STUDENT"; // Default role
        }
        if (this.createdAt == null) {
            this.createdAt = Instant.now();
        }
    }
}