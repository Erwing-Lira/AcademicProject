package com.elira.academic.features.period.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePeriodoDTO {
    private String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
