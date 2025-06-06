package com.elira.academic.features.professor.service;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.professor.dto.CreateProfessorDTO;
import com.elira.academic.features.professor.model.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {
    Professor create(CreateProfessorDTO dto);
    List<Professor> findAll();
    Optional<Professor> seeDetail(Long id);
    Optional<List<Asignature>> listAsignatures(Long id);
}
