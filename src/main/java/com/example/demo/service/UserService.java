package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User register(RegisterRequest req); [cite: 91]
    User getById(Long id); [cite: 91]
    User findByEmail(String email); [cite: 91]
    List<User> listInstructors(); [cite: 92]
}