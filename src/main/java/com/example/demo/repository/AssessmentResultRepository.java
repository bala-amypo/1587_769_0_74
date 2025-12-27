package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {
    List<AssessmentResult> findByStudentProfileId(Long studentProfileId); [cite: 56]
    List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentId, Long skillId); [cite: 57]
}