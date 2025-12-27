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

    private final SkillGapRecommendationRepository recommendationRepo;
    private final StudentProfileRepository profileRepo;
    private final SkillRepository skillRepo;

    public RecommendationServiceImpl(
            SkillGapRecommendationRepository recommendationRepo,
            StudentProfileRepository profileRepo,
            SkillRepository skillRepo
    ) {
        this.recommendationRepo = recommendationRepo;
        this.profileRepo = profileRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<Skill> skills = skillRepo.findByActiveTrue();
        List<SkillGapRecommendation> list = new ArrayList<>();

        skills.forEach(skill -> {

            SkillGapRecommendation rec = new SkillGapRecommendation();
            rec.setStudentProfile(profileRepo.findById(studentId).orElse(null));
            rec.setSkill(skill);

            // Adjust based on your entity field names
            rec.setGap("MEDIUM");
            rec.setCreatedAt(Instant.now());

            list.add(recommendationRepo.save(rec));
        });

        return list;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepo.findByStudentProfileIdOrderByCreatedAtDesc(studentId);
    }
}
