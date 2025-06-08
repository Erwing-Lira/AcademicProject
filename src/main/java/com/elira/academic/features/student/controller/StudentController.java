package com.elira.academic.features.student.controller;

import com.elira.academic.features.notes.dto.NoteMapper;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.student.dto.CreateStudentDTO;
import com.elira.academic.features.student.dto.StudentMapper;
import com.elira.academic.features.student.model.Student;
import com.elira.academic.features.student.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(
            IStudentService studentService
    ) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateStudentDTO student
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        StudentMapper.toDTO(
                                studentService.create(student)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                studentService.findAll()
                        .stream()
                        .map(StudentMapper::toDTO)
        );
    }


    @PreAuthorize("hasRole('ESTUDIANTE')")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id
    ) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (optionalStudent.isPresent()) {
            return ResponseEntity.ok(
                    StudentMapper.toDTO(optionalStudent.get())
            );
        }

        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ESTUDIANTE')")
    @GetMapping("/{id}/notes")
    public ResponseEntity<?> findNotesById(
            @PathVariable Long id
    ) {
        Optional<List<Note>> optionalNotes = studentService.findNotesById(id);

        if (optionalNotes.isPresent()) {
            return ResponseEntity.ok(
                    optionalNotes.get().stream()
                            .map(NoteMapper::toDTO)
            );
        }

        return ResponseEntity.notFound().build();
    }
}
