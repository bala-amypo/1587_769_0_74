package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentResultService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessments")
@Tag(name = "Assessments")
public class AssessmentController {
    private final AssessmentResultService assessmentService;

    public AssessmentController(AssessmentResultService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> recordResult(@RequestBody AssessmentResult result) {
        [cite_start]// Record assessment result [cite: 110]
        return ResponseEntity.ok(assessmentService.recordAssessment(result));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getByStudent(@PathVariable Long studentId) {
        [cite_start]// Get all results for student [cite: 111]
        return ResponseEntity.ok(assessmentService.getResultsByStudent(studentId));
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<?> getByStudentAndSkill(@PathVariable Long studentId, @PathVariable Long skillId) {
        [cite_start]// Get results for student and specific skill [cite: 112]
        return ResponseEntity.ok(assessmentService.getResultsByStudentAndSkill(studentId, skillId));
    }
}