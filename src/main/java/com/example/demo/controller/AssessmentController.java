package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessments")
@Tag(name = "Assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    // POST /api/assessments
    @PostMapping
    public ResponseEntity<?> recordResult(@RequestBody AssessmentResult result) {
        return ResponseEntity.ok(assessmentService.recordAssessment(result));
    }

    // GET /api/assessments/student/{studentId}
    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(
                assessmentService.getResultsByStudent(studentId)
        );
    }

    // GET /api/assessments/student/{studentId}/skill/{skillId}
    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<?> getByStudentAndSkill(
            @PathVariable Long studentId,
            @PathVariable Long skillId) {

        return ResponseEntity.ok(
                assessmentService.getResultsByStudentAndSkill(studentId, skillId)
        );
    }
}
