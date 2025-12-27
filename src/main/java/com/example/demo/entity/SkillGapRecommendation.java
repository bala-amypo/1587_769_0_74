package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class SkillGapRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    @ManyToOne(optional = false)
    private Skill skill;

    @Column(nullable = false)
    private String recommendedAction;

    private String priority; // HIGH / MEDIUM / LOW

    @Column(nullable = false)
    private Double gapScore;

    private String generatedBy;

    @Builder.Default
    private Instant generatedAt = Instant.now();
}