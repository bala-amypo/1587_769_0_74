package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createSkill(@RequestBody Skill skill) {
        [cite_start]// Create skill [cite: 104]
        return ResponseEntity.ok(skillService.createSkill(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        [cite_start]// Update skill [cite: 105]
        return ResponseEntity.ok(skillService.updateSkill(id, skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        [cite_start]// Get skill by id [cite: 106]
        return ResponseEntity.ok(skillService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> listAll() {
        [cite_start]// List all skills [cite: 107]
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivate(@PathVariable Long id) {
        [cite_start]// Deactivate skill [cite: 108]
        skillService.deactivateSkill(id);
        return ResponseEntity.ok().build();
    }
}