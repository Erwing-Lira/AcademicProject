package com.elira.academic.features.student.service;

import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.student.dto.CreateStudentDTO;
import com.elira.academic.features.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student create(CreateStudentDTO dto);
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Optional<List<Note>> findNotesById(Long id);
}
