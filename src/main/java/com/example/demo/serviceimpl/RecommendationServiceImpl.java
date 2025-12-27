package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AssessmentResultRepository assessmentRepo;
    private final SkillGapRecommendationRepository recommendationRepo;
    private final StudentProfileRepository profileRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            AssessmentResultRepository assessmentRepo,
            SkillGapRecommendationRepository recommendationRepo,
            StudentProfileRepository profileRepo,
            SkillRepository skillRepo
    ) {
        this.assessmentRepo = assessmentRepo;
        this.recommendationRepo = recommendationRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecommendation> results = new ArrayList<>();

        for (Skill skill : skills) {

            SkillGapRecommendation rec = new SkillGapRecommendation();
            rec.setStudentProfile(profileRepo.findById(studentId).orElse(null));
            rec.setSkill(skill);
            rec.setGapLevel("MEDIUM"); // placeholder
            rec.setGeneratedAt(Instant.now());

            results.add(recommendationRepo.save(rec));
        }

        return results;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepo
                .findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}
