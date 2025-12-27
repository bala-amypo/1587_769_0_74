package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

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
    public SkillGapRecommendation computeRecommendationForStudentSkill(
            Long studentId,
            Long skillId
    ) {
        // TODO: implement scoring logic
        // Returning null temporarily to satisfy compilation
        return null;
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {

        List<Skill> activeSkills = skillRepo.findByActiveTrue();

        // TODO: iterate + compute + save recommendations based on gap score

        return recommendationRepo.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepo.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}
