package com.elira.academic.features.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNoteDTO {
    private Double value;
    private String observations;
    private Long asignatureId;
    private Long studentId;
    private Long periodoId;
}
