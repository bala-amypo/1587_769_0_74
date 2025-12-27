package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill); [cite: 75]
    Skill updateSkill(Long id, Skill skill); [cite: 76]
    Skill getById(Long id); [cite: 76]
    List<Skill> getAllSkills(); [cite: 76]
    List<Skill> getActiveSkills(); [cite: 76]
    void deactivateSkill(Long id); [cite: 76]
}