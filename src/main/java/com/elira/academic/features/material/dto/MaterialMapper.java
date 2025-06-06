package com.elira.academic.features.material.dto;

import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.material.model.Material;
import com.elira.academic.features.professor.dto.ProfessorMapper;
import com.elira.academic.features.professor.model.Professor;

public class MaterialMapper {
    public static MaterialDTO toDTO(Material material) {
        return MaterialDTO.builder()
                .id(material.getId())
                .title(material.getTitle())
                .description(material.getDescription())
                .urlFile(material.getUrlFile())
                .asignature(AsignatureMapper.toDTO(material.getAsignature()))
                .professor(ProfessorMapper.toDTO(material.getProfessor()))
                .build();
    }

    public static Material toEntity(
            CreateMaterialDTO dto,
            Asignature asignature,
            Professor professor
    ) {
        return Material.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .urlFile(dto.getUrlFile())
                .asignature(asignature)
                .professor(professor)
                .build();
    }
}
