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

    // POST /api/skills
    @PostMapping
    public ResponseEntity<?> createSkill(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.createSkill(skill));
    }

    // PUT /api/skills/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSkill(
            @PathVariable Long id,
            @RequestBody Skill skill) {

        return ResponseEntity.ok(skillService.updateSkill(id, skill));
    }

    // GET /api/skills/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getById(id));
    }

    // GET /api/skills
    @GetMapping
    public ResponseEntity<?> listAll() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    // PUT /api/skills/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivate(@PathVariable Long id) {
        skillService.deactivateSkill(id);
        return ResponseEntity.ok().build();
    }
}
