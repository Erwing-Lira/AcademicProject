package com.elira.academic.features.material.service;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.asignature.repository.AsignatureRepository;
import com.elira.academic.features.material.dto.CreateMaterialDTO;
import com.elira.academic.features.material.dto.MaterialMapper;
import com.elira.academic.features.material.model.Material;
import com.elira.academic.features.material.repository.MaterialRepository;
import com.elira.academic.features.professor.model.Professor;
import com.elira.academic.features.professor.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialServiceImpl implements IMaterialService{
    private final MaterialRepository materialRepository;
    private final AsignatureRepository asignatureRepository;
    private final ProfessorRepository professorRepository;

    public MaterialServiceImpl(
            MaterialRepository materialRepository,
            AsignatureRepository asignatureRepository,
            ProfessorRepository professorRepository
    ) {
        this.materialRepository = materialRepository;
        this.asignatureRepository = asignatureRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Material create(CreateMaterialDTO dto) {
        Asignature asignature = asignatureRepository.findById(dto.getAsignatureId())
                .orElseThrow();
        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow();

        Material material = MaterialMapper.toEntity(dto, asignature, professor);

        return materialRepository.save(material);
    }

    @Override
    public Optional<Material> findById(Long id) {
        return materialRepository.findById(id);
    }

    @Override
    public Optional<Material> deleteById(Long id) {
        Optional<Material> materialOptional = materialRepository.findById(id);
        materialOptional.ifPresent(materialRepository::delete);
        return materialOptional;
    }
}
