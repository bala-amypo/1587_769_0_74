package com.example.demo.service;

import com.example.demo.entity.SkillGapRecord;
import java.util.List;

public interface SkillGapService {
    List<SkillGapRecord> computeGaps(Long studentProfileId); [cite: 83]
    List<SkillGapRecord> getGapsByStudent(Long studentId); [cite: 83]
}