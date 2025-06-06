package com.elira.academic.features.period.service;

import com.elira.academic.features.period.dto.CreatePeriodoDTO;
import com.elira.academic.features.period.model.PeriodoLectivo;

import java.util.List;
import java.util.Optional;

public interface IPeriodService {
    PeriodoLectivo create(CreatePeriodoDTO dto);
    List<PeriodoLectivo> findAll();
    Optional<PeriodoLectivo> findById(Long id);
}
