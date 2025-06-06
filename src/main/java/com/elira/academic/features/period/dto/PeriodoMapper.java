package com.elira.academic.features.period.dto;

import com.elira.academic.features.period.model.PeriodoLectivo;

public class PeriodoMapper {
    public static PeriodoDTO toDTO(PeriodoLectivo periodoLectivo) {
        return PeriodoDTO.builder()
                .id(periodoLectivo.getId())
                .nombre(periodoLectivo.getNombre())
                .fechaInicio(periodoLectivo.getFechaInicio())
                .fechaFin(periodoLectivo.getFechaFin())
                .build();
    }

    public static PeriodoLectivo toEntity(CreatePeriodoDTO dto) {
        return PeriodoLectivo.builder()
                .nombre(dto.getNombre())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .build();
    }
}
