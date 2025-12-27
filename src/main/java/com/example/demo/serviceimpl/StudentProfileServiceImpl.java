package com.example.demo.serviceimpl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository profileRepository;

    public StudentProfileServiceImpl(StudentProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public StudentProfile createProfile(StudentProfile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public StudentProfile updateProfile(Long id, StudentProfile profile) {
        StudentProfile existing = getProfile(id);
        existing.setName(profile.getName());
        existing.setDepartment(profile.getDepartment());
        existing.setCohort(profile.getCohort());
        return profileRepository.save(existing);
    }

    @Override
    public StudentProfile getProfile(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
            return profileRepository.findAll();
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
