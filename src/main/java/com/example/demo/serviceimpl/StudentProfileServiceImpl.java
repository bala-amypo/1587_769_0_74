package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    private final StudentProfileRepository repo; [cite: 71]

    public StudentProfileServiceImpl(StudentProfileRepository repo) { [cite: 71]
        this.repo = repo;
    }

    @Override
    public StudentProfile createOrUpdateProfile(StudentProfile profile) {
        if (profile.getId() == null && repo.existsByEnrollmentId(profile.getEnrollmentId())) { [cite: 72]
            throw new IllegalArgumentException("enrollmentId already exists"); [cite: 24, 72]
        }
        return repo.save(profile); [cite: 72]
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found")); [cite: 24, 72]
    }

    @Override
    public StudentProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("profile not found")); [cite: 24, 72]
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repo.findByEnrollmentId(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("profile not found")); [cite: 24, 72]
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repo.findAll(); [cite: 50, 72]
    }
}