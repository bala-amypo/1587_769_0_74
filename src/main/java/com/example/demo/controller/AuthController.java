package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Register User
    @PostMapping("/register")
    public UserDTO register(@RequestBody User user) {
        return toDTO(userService.register(user));
    }

    // Login User
    @PostMapping("/login")
    public UserDTO login(@RequestParam String username,
                         @RequestParam String password) {
        return toDTO(userService.login(username, password));
    }

    // Get User by ID
    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return toDTO(userService.getById(id));
    }

    // List All Users
    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    // Deactivate User
    @PutMapping("/deactivate/{id}")
    public void deactivate(@PathVariable Long id) {
        userService.deactivateUser(id);
    }

    private UserDTO toDTO(User u) {
        return UserDTO.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .role(u.getRole())
                .build();
    }
}
