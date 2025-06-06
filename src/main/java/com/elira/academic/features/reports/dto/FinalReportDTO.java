package com.elira.academic.features.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinalReportDTO {
    private String student;
    private String asignature;
    private Double average;
}
