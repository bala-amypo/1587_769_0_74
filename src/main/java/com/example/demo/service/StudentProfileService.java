package com.example.demo.controller;

import com.example.demo.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
@Tag(name = "Recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/generate/{studentId}")
    public ResponseEntity<?> generate(@PathVariable Long studentId) {
        [cite_start]// Generate recommendations for student [cite: 117]
        return ResponseEntity.ok(recommendationService.computeRecommendationsForStudent(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getByStudent(@PathVariable Long studentId) {
        [cite_start]// Get stored recommendations ordered by generatedAt [cite: 118]
        return ResponseEntity.ok(recommendationService.getRecommendationsForStudent(studentId));
    }
}