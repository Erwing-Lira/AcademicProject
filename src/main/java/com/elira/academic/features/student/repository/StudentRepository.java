package com.elira.academic.features.student.repository;

import com.elira.academic.features.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
