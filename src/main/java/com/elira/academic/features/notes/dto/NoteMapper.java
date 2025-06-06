package com.elira.academic.features.notes.dto;

import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.period.dto.PeriodoMapper;
import com.elira.academic.features.period.model.PeriodoLectivo;
import com.elira.academic.features.student.dto.StudentMapper;
import com.elira.academic.features.student.model.Student;

public class NoteMapper {
    public static NoteDTO toDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setValue(note.getValue());
        noteDTO.setObservations(note.getObservations());

        if (note.getAsignature() != null) {
            noteDTO.setAsignature(AsignatureMapper.toDTO(note.getAsignature()));
        }

        if (note.getStudent() != null) {
            noteDTO.setStudent(StudentMapper.toDTO(note.getStudent()));
        }

        if (note.getPeriodoLectivo() != null) {
            noteDTO.setPeriodo(PeriodoMapper.toDTO(note.getPeriodoLectivo()));
        }

        return noteDTO;
    }

    public static NoteFilterDTO toFilterDTO(Note note) {
        return NoteFilterDTO.builder()
                .id(note.getId())
                .value(note.getValue())
                .observations(note.getObservations())
                .build();
    }

    public static Note toEntity(
            CreateNoteDTO dto,
            Student student,
            Asignature asignature,
            PeriodoLectivo periodoLectivo
    ) {
        return Note.builder()
                .value(dto.getValue())
                .observations(dto.getObservations())
                .student(student)
                .asignature(asignature)
                .periodoLectivo(periodoLectivo)
                .build();
    }
}
