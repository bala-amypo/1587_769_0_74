package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repo; [cite: 74]

    public SkillServiceImpl(SkillRepository repo) { [cite: 74]
        this.repo = repo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        if (repo.findByCode(skill.getCode()).isPresent()) { [cite: 75]
            throw new IllegalArgumentException("skill code must be unique"); [cite: 27, 76]
        }
        if (skill.getMinCompetencyScore() < 0 || skill.getMinCompetencyScore() > 100) { [cite: 27, 75]
            throw new IllegalArgumentException("Score must be between 0 and 100"); [cite: 66]
        }
        return repo.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("skill not found")); [cite: 76]
        existing.setName(skill.getName());
        existing.setCategory(skill.getCategory());
        existing.setMinCompetencyScore(skill.getMinCompetencyScore());
        return repo.save(existing);
    }

    @Override
    public Skill getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("skill not found")); [cite: 76]
    }

    @Override
    public List<Skill> getAllSkills() {
        return repo.findAll(); [cite: 54, 76]
    }

    @Override
    public List<Skill> getActiveSkills() {
        return repo.findByActiveTrue(); [cite: 53, 76]
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill skill = getById(id);
        skill.setActive(false); [cite: 76]
        repo.save(skill);
    }
}