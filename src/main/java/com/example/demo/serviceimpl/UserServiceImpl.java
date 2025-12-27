package com.example.demo.serviceimpl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.config.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo; [cite: 90]
    private final PasswordEncoder passwordEncoder; [cite: 90]
    private final JwtUtil jwtUtil; [cite: 90]

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) { [cite: 90]
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(RegisterRequest req) {
        if (repo.existsByEmail(req.getEmail())) { [cite: 91]
            throw new IllegalArgumentException("Email already exists"); [cite: 21, 66]
        }
        User user = User.builder()
                .fullName(req.getFullName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword())) [cite: 21, 91]
                .role(req.getRole() == null ? User.Role.STUDENT : User.Role.valueOf(req.getRole())) [cite: 21, 91]
                .build();
        return repo.save(user);
    }

    @Override
    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found")); [cite: 66, 91]
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("user not found")); [cite: 91]
    }

    @Override
    public List<User> listInstructors() {
        return repo.findByRole(User.Role.INSTRUCTOR); [cite: 92]
    }
}