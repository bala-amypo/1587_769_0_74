package com.example.demo.controller;

import com.example.demo.service.SkillGapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gaps")
@Tag(name = "Gaps")
public class SkillGapController {
    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @PostMapping("/compute/{studentId}")
    public ResponseEntity<?> computeGaps(@PathVariable Long studentId) {
        [cite_start]// Compute and persist skill gaps for student [cite: 114]
        return ResponseEntity.ok(skillGapService.computeGaps(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getGapsByStudent(@PathVariable Long studentId) {
        [cite_start]// Get stored gap records for student [cite: 115]
        return ResponseEntity.ok(skillGapService.getGapsByStudent(studentId));
    }
}