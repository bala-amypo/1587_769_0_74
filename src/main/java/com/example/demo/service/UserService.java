package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserByEmail(String email);
    List<User> getUsersByRole(User.Role role);
    User getUserById(Long id);
}