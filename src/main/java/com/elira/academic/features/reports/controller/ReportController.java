package com.elira.academic.features.reports.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @GetMapping("/notes-average")
    public ResponseEntity<?> notesAverage() {
        return null;
    }

    @GetMapping("/student-history/{studentId}")
    public ResponseEntity<?> studentHistory(
            @PathVariable Long studentId
    ) {
        return null;
    }

    @GetMapping("/final-report/{courseId}")
    public ResponseEntity<?> finalReport(
            @PathVariable Long courseId
    ) {
        return null;
    }
}
