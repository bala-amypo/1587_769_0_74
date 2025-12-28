package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // =========================
    // Register  (PUBLIC)
    // =========================
    @PostMapping("/register")
    @Operation(summary = "Register new user")
    public UserDTO register(@RequestBody User user) {
        return toDTO(userService.register(user));
    }

    // =========================
    // Login  (PUBLIC)
    // =========================
    @PostMapping("/login")
    @Operation(summary = "User login")
    public UserDTO login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return toDTO(userService.login(username, password));
    }

    // =========================
    // Get User by ID  (PUBLIC)
    // =========================
    @GetMapping("/user/{id}")
    @Operation(summary = "Get user by ID")
    public UserDTO getUser(@PathVariable Long id) {
        return toDTO(userService.getById(id));
    }

    // =========================
    // List All Users  (PUBLIC)
    // =========================
    @GetMapping("/users")
    @Operation(summary = "Get all users")
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    // =========================
    // Deactivate User (SECURED)
    // =========================
    @PutMapping("/deactivate/{id}")
    @Operation(
            summary = "Deactivate user (Requires JWT)",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public void deactivate(@PathVariable Long id) {
        userService.deactivateUser(id);
    }

    // =========================
    // DTO MAPPER
    // =========================
    private UserDTO toDTO(User u) {
        return UserDTO.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .role(u.getRole())
                .build();
    }
}
