package com.elira.academic.features.period.repository;

import com.elira.academic.features.period.model.PeriodoLectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<PeriodoLectivo, Long> {
}
