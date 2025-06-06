package com.elira.academic.features.professor.repository;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.professor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
