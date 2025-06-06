package com.elira.academic.features.professor.controller;

import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.professor.dto.CreateProfessorDTO;
import com.elira.academic.features.professor.dto.ProfessorMapper;
import com.elira.academic.features.professor.model.Professor;
import com.elira.academic.features.professor.service.IProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private final IProfessorService professorService;

    public ProfessorController(
            IProfessorService professorService
    ) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateProfessorDTO professor
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ProfessorMapper.toDTO(
                                professorService.create(professor)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                professorService.findAll().stream()
                        .map(ProfessorMapper::toDTO)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> seeDetails(
            @PathVariable Long id
    ) {
        Optional<Professor> professorOptional = professorService.seeDetail(id);

        if (professorOptional.isPresent()) {
            return ResponseEntity.ok(
                    ProfessorMapper.toDTO(
                            professorOptional.get()
                    )
            );
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/asignatures")
    public ResponseEntity<?> seeAsignatures(
            @PathVariable Long id
    ) {
        Optional<List<Asignature>> optionalAsignatures = professorService.listAsignatures(id);

        if (optionalAsignatures.isPresent()) {
            return ResponseEntity.ok(optionalAsignatures.get().stream()
                    .map(AsignatureMapper::toDTO));
        }
        return ResponseEntity.notFound().build();
    }
}
