package com.elira.academic.features.notes.service;

import com.elira.academic.features.notes.dto.CreateNoteDTO;
import com.elira.academic.features.notes.model.Note;

import java.util.List;
import java.util.Optional;

public interface INoteService {
    Note create(CreateNoteDTO dto);
    List<Note> listAsignatures(Long id);
    List<Note> listStudent(Long id);
    Optional<Note> editById(Long id, CreateNoteDTO dto);
    Optional<Note> deleteById(Long id);
}
