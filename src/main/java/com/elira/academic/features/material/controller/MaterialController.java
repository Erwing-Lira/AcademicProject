package com.elira.academic.features.material.controller;

import com.elira.academic.features.material.dto.CreateMaterialDTO;
import com.elira.academic.features.material.dto.MaterialMapper;
import com.elira.academic.features.material.model.Material;
import com.elira.academic.features.material.service.IMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {
    private final IMaterialService materialService;

    public MaterialController(
            IMaterialService materialService
    ) {
        this.materialService = materialService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateMaterialDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        MaterialMapper.toDTO(materialService.create(dto))
                );
    }

    @PreAuthorize("hasRole('ESTUDIANTE')")
    @GetMapping("/asignature/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id
    ) {
        Optional<Material> materialOptional = materialService.findById(id);

        if (materialOptional.isPresent()) {
            return ResponseEntity.ok(
                    MaterialMapper.toDTO(materialOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable Long id
    ) {
        Optional<Material> materialOptional = materialService.deleteById(id);

        if (materialOptional.isPresent()) {
            return ResponseEntity.ok(
                    MaterialMapper.toDTO(materialOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }
}
