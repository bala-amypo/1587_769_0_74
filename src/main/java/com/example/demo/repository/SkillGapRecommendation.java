package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {
    // Fetches history ordered by generatedAt descending as required [cite: 62]
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentProfileId); [cite: 62]
}