package com.elira.academic.features.asignature.controller;

import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.asignature.dto.CreateAsignatureDTO;
import com.elira.academic.features.asignature.dto.EditAsignatureDTO;
import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.asignature.service.IAsignatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/asignatures")
public class AsigntaureController {
    private final IAsignatureService asignatureService;

    public AsigntaureController(
            IAsignatureService asignatureService
    ) {
        this.asignatureService = asignatureService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateAsignatureDTO asignature
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        AsignatureMapper.toDTO(asignatureService.create(asignature))
                );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                asignatureService.findAll()
                        .stream()
                        .map(AsignatureMapper::toDTO)
        );
    }

    @PreAuthorize("hasRole('ESTUDIANTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> findByID(
            @PathVariable Long id
    ) {
        Optional<Asignature> asignatureOptional = asignatureService.findById(id);

        if (asignatureOptional.isPresent()) {
            return ResponseEntity.ok(
                    AsignatureMapper.toDTO(asignatureOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editByID(
            @PathVariable Long id,
            @RequestBody EditAsignatureDTO dto
    ) {
        Optional<Asignature> asignatureOptional = asignatureService.editById(id, dto);

        if (asignatureOptional.isPresent()) {
            return ResponseEntity.ok(
                    AsignatureMapper.toDTO(asignatureOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByID(
            @PathVariable Long id
    ) {
        Optional<Asignature> asignatureOptional = asignatureService.deleteById(id);

        if (asignatureOptional.isPresent()) {
            return ResponseEntity.ok(
                    AsignatureMapper.toDTO(asignatureOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }
}
