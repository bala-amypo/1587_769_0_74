package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {
    SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId); [cite: 86]
    List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId); [cite: 87]
    List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId); [cite: 88]
}