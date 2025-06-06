package com.elira.academic.features.period.controller;

import com.elira.academic.features.period.dto.CreatePeriodoDTO;
import com.elira.academic.features.period.dto.PeriodoMapper;
import com.elira.academic.features.period.model.PeriodoLectivo;
import com.elira.academic.features.period.service.IPeriodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/periods")
public class PeriodsController {
    private final IPeriodService periodService;

    public PeriodsController(
            IPeriodService periodService
    ) {
        this.periodService = periodService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreatePeriodoDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        PeriodoMapper.toDTO(periodService.create(dto))
                );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                periodService.findAll().stream()
                        .map(PeriodoMapper::toDTO)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id
    ) {
        Optional<PeriodoLectivo> periodoLectivoOptional = periodService.findById(id);

        if (periodoLectivoOptional.isPresent()) {
            return ResponseEntity.ok(
                    PeriodoMapper.toDTO(periodoLectivoOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }
}
