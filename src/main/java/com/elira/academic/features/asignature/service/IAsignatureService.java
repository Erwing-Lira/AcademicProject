package com.elira.academic.features.asignature.service;

import com.elira.academic.features.asignature.dto.CreateAsignatureDTO;
import com.elira.academic.features.asignature.dto.EditAsignatureDTO;
import com.elira.academic.features.asignature.model.Asignature;

import java.util.List;
import java.util.Optional;

public interface IAsignatureService {
    Asignature create(CreateAsignatureDTO dto);
    List<Asignature> findAll();
    Optional<Asignature> findById(Long id);
    Optional<Asignature> editById(Long id, EditAsignatureDTO dto);
    Optional<Asignature> deleteById(Long id);
}
