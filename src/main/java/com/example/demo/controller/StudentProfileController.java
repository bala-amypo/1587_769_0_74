package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Students")
public class StudentProfileController {
    private final StudentProfileService profileService;

    public StudentProfileController(StudentProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createProfile(@RequestBody StudentProfile profile) {
        [cite_start]// Creates student profile [cite: 99]
        return ResponseEntity.ok(profileService.createOrUpdateProfile(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        [cite_start]// Get profile by id [cite: 100]
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public ResponseEntity<?> getByEnrollmentId(@PathVariable String enrollmentId) {
        [cite_start]// Get profile by enrollment ID [cite: 101]
        return ResponseEntity.ok(profileService.getProfileByEnrollmentId(enrollmentId));
    }

    @GetMapping("/")
    public ResponseEntity<?> listAll() {
        [cite_start]// List all profiles [cite: 102]
        return ResponseEntity.ok(profileService.getAllProfiles());
    }
}