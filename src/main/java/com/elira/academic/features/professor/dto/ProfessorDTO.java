package com.elira.academic.features.professor.dto;

import com.elira.academic.features.asignature.dto.AsignatureDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {
    private Long id;
    private String specialty;
    private String name;
    private String email;
    private List<AsignatureDTO> asignatures;
}
