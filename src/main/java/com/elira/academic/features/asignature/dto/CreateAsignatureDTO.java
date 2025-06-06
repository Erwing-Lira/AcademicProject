package com.elira.academic.features.asignature.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAsignatureDTO {
    private String name;
    private Long courseId;
    private Long professorId;
}
