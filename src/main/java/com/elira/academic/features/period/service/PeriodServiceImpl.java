package com.elira.academic.features.period.service;

import com.elira.academic.features.period.dto.CreatePeriodoDTO;
import com.elira.academic.features.period.dto.PeriodoMapper;
import com.elira.academic.features.period.model.PeriodoLectivo;
import com.elira.academic.features.period.repository.PeriodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodServiceImpl implements IPeriodService {
    private final PeriodRepository periodRepository;

    public PeriodServiceImpl(
            PeriodRepository periodRepository
    ) {
        this.periodRepository = periodRepository;
    }

    @Override
    public PeriodoLectivo create(CreatePeriodoDTO dto) {
        return periodRepository.save(
                PeriodoMapper.toEntity(dto)
        );
    }

    @Override
    public List<PeriodoLectivo> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public Optional<PeriodoLectivo> findById(Long id) {
        return periodRepository.findById(id);
    }
}
