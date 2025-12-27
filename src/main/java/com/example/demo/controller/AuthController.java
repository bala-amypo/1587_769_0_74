package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public UserDTO register(@RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return toDTO(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginRequest request) {
        User user = userService.login(request.getEmail(), request.getPassword());
        return toDTO(user);
    }

    // GET /auth/user/{id}
    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return toDTO(userService.getById(id));
    }

    private UserDTO toDTO(User u) {
        return UserDTO.builder()
                .id(u.getId())
                .fullName(u.getFullName())
                .email(u.getEmail())
                .role(u.getRole())
                .createdAt(u.getCreatedAt())
                .build();
    }
}
