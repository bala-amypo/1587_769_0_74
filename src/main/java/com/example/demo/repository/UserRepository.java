package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); [cite: 44]
    Optional<User> findByEmail(String email); [cite: 45]
    List<User> findByRole(User.Role role); [cite: 92]
}