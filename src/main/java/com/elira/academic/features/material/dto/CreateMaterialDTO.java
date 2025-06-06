package com.elira.academic.features.material.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMaterialDTO {
    private String title;
    private String description;
    private String urlFile;
    private Long asignatureId;
    private Long professorId;
}
