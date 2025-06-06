package com.elira.academic.features.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteFilterDTO {
    private Long id;
    private Double value;
    private String observations;
}
