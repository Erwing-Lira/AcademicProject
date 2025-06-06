package com.elira.academic.features.notes.service;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.asignature.repository.AsignatureRepository;
import com.elira.academic.features.notes.dto.CreateNoteDTO;
import com.elira.academic.features.notes.dto.NoteMapper;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.notes.repository.NoteRepository;
import com.elira.academic.features.period.model.PeriodoLectivo;
import com.elira.academic.features.period.repository.PeriodRepository;
import com.elira.academic.features.student.model.Student;
import com.elira.academic.features.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements INoteService {
    private final NoteRepository noteRepository;
    private final StudentRepository studentRepository;
    private final AsignatureRepository asignatureRepository;
    private final PeriodRepository periodRepository;

    public NoteServiceImpl(
            NoteRepository noteRepository,
            StudentRepository studentRepository,
            AsignatureRepository asignatureRepository,
            PeriodRepository periodRepository
    ) {
        this.noteRepository = noteRepository;
        this.studentRepository = studentRepository;
        this.asignatureRepository = asignatureRepository;
        this.periodRepository = periodRepository;
    }

    @Override
    public Note create(CreateNoteDTO dto) {
        Student student = null;
        Asignature asignature = null;
        PeriodoLectivo periodoLectivo = null;

        if (dto.getStudentId() == null &&
                dto.getAsignatureId() == null &&
                dto.getPeriodoId() == null
        ) {
            throw new IllegalArgumentException();
        }

        if (dto.getStudentId() != null) {
            student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow();
        }

        if (dto.getAsignatureId() != null) {
            asignature = asignatureRepository.findById(dto.getAsignatureId())
                    .orElseThrow();
        }

        if (dto.getPeriodoId() != null) {
            periodoLectivo = periodRepository.findById(dto.getPeriodoId())
                    .orElseThrow();
        }

        Note note = NoteMapper.toEntity(dto, student, asignature, periodoLectivo);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> listAsignatures(Long id) {
        return noteRepository.findByAsignatureId(id);
    }

    @Override
    public List<Note> listStudent(Long id) {
        return noteRepository.findByStudentId(id);
    }

    @Override
    public Optional<Note> editById(Long id, CreateNoteDTO dto) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        if (noteOptional.isPresent()) {
            Note newNote = noteOptional.get();

            if (dto.getValue() != null) {
                newNote.setValue(dto.getValue());
            }
            if (dto.getObservations() != null) {
                newNote.setObservations(dto.getObservations());
            }

            Student student = null;
            if (dto.getStudentId() != null) {
                student = studentRepository.findById(dto.getStudentId())
                        .orElseThrow();
            }
            newNote.setStudent(student);

            Asignature asignature = null;
            if (dto.getAsignatureId() != null) {
                asignature = asignatureRepository.findById(dto.getAsignatureId())
                        .orElseThrow();
            }
            newNote.setAsignature(asignature);

            PeriodoLectivo periodoLectivo = null;
            if (dto.getPeriodoId() != null) {
                periodoLectivo = periodRepository.findById(dto.getPeriodoId())
                        .orElseThrow();
            }
            newNote.setPeriodoLectivo(periodoLectivo);

            return Optional.of(noteRepository.save(newNote));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Note> deleteById(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        noteOptional.ifPresent(noteRepository::delete);
        return noteOptional;
    }
}
