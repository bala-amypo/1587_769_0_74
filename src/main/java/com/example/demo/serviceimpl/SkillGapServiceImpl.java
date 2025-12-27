package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SkillGapServiceImpl implements SkillGapService {
    private final SkillGapRecordRepository repo; [cite: 82]
    private final SkillRepository skillRepo; [cite: 82]
    private final AssessmentResultRepository assessmentRepo; [cite: 82]

    public SkillGapServiceImpl(SkillGapRecordRepository repo, SkillRepository skillRepo, AssessmentResultRepository assessmentRepo) { [cite: 82]
        this.repo = repo;
        this.skillRepo = skillRepo;
        this.assessmentRepo = assessmentRepo;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {
        List<Skill> activeSkills = skillRepo.findByActiveTrue(); [cite: 53, 83]
        List<SkillGapRecord> gaps = new ArrayList<>();

        for (Skill skill : activeSkills) {
            List<AssessmentResult> results = assessmentRepo.findByStudentProfileIdAndSkillId(studentProfileId, skill.getId()); [cite: 57, 83]
            double currentScore = results.isEmpty() ? 0.0 : results.get(results.size() - 1).getScore(); [cite: 33, 83]
            
            SkillGapRecord record = SkillGapRecord.builder()
                .studentProfile(StudentProfile.builder().id(studentProfileId).build())
                .skill(skill)
                .currentScore(currentScore)
                .targetScore(skill.getMinCompetencyScore())
                .gapScore(skill.getMinCompetencyScore() - currentScore) [cite: 33]
                .build();
            gaps.add(repo.save(record)); [cite: 83]
        }
        return gaps;
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return repo.findByStudentProfileId(studentId); [cite: 60, 83]
    }
}