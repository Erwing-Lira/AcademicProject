package com.elira.academic.features.asignature.repository;

import com.elira.academic.features.asignature.model.Asignature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignatureRepository extends JpaRepository<Asignature, Long> {
}
