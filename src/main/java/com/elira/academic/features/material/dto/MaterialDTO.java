package com.elira.academic.features.material.dto;

import com.elira.academic.features.asignature.dto.AsignatureDTO;
import com.elira.academic.features.professor.dto.ProfessorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialDTO {
    private Long id;
    private String title;
    private String description;
    private String urlFile;
    private AsignatureDTO asignature;
    private ProfessorDTO professor;
}
