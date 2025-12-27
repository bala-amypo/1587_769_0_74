package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile createProfile(StudentProfile profile);

    StudentProfile updateProfile(Long id, StudentProfile profile);

    StudentProfile getProfile(Long id);

    List<StudentProfile> getAllProfiles();

    void deleteProfile(Long id);
}
