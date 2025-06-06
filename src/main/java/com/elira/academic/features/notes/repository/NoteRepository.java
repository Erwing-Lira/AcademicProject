package com.elira.academic.features.notes.repository;

import com.elira.academic.features.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByAsignatureId(Long id);
    List<Note> findByStudentId(Long id);
    List<Note> findByStudentCourseId(Long id);
}
