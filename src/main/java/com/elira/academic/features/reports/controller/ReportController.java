package com.elira.academic.features.reports.controller;

import com.elira.academic.features.asignature.service.IAsignatureService;
import com.elira.academic.features.notes.service.INoteService;
import com.elira.academic.features.reports.service.IReportService;
import com.elira.academic.features.student.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final IReportService reportService;

    public ReportController(
            IReportService reportService
    ) {
        this.reportService = reportService;
    }

    @GetMapping("/notes-average")
    public ResponseEntity<?> notesAverage() {
        return ResponseEntity.ok(reportService.average());
    }

    @GetMapping("/student-history/{studentId}")
    public ResponseEntity<?> studentHistory(
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(reportService.noteHistory(studentId));
    }

    @GetMapping("/final-report/{courseId}")
    public ResponseEntity<?> finalReport(
            @PathVariable Long courseId
    ) {
        return ResponseEntity.ok(reportService.finalReportByCourse(courseId));
    }
}
