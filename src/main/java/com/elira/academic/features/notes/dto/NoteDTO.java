package com.elira.academic.features.notes.dto;

import com.elira.academic.features.asignature.dto.AsignatureDTO;
import com.elira.academic.features.period.dto.PeriodoDTO;
import com.elira.academic.features.student.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDTO {
    private Long id;
    private Double value;
    private String observations;
    private AsignatureDTO asignature;
    private StudentDTO student;
    private PeriodoDTO periodo;
}
