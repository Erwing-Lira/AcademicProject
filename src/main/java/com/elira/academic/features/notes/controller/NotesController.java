package com.elira.academic.features.notes.controller;

import com.elira.academic.features.notes.dto.CreateNoteDTO;
import com.elira.academic.features.notes.dto.NoteMapper;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.notes.service.INoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private final INoteService noteService;

    public NotesController(
            INoteService noteService
    ) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateNoteDTO dto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        NoteMapper.toDTO(noteService.create(dto))
                );
    }

    @GetMapping("/asignature/{id}")
    public ResponseEntity<?> findByAsignatureId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                noteService.listAsignatures(id).stream()
                        .map(NoteMapper::toFilterDTO)
        );
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> findByStudentId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                noteService.listStudent(id).stream()
                        .map(NoteMapper::toFilterDTO)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editById(
            @PathVariable Long id,
            @RequestBody CreateNoteDTO dto
    ) {
        Optional<Note> noteOptional = noteService.editById(id, dto);

        if (noteOptional.isPresent()) {
            return ResponseEntity.ok(
                    NoteMapper.toDTO(noteOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable Long id
    ) {
        Optional<Note> noteOptional = noteService.deleteById(id);

        if (noteOptional.isPresent()) {
            return ResponseEntity.ok(
                    NoteMapper.toDTO(noteOptional.get())
            );
        }
        return ResponseEntity.notFound().build();
    }
}
