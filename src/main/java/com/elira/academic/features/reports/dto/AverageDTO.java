package com.elira.academic.features.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AverageDTO {
    private String course;
    private String asignature;
    private Double promedio;
}
