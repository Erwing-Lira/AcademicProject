package com.elira.academic.features.reports.service;

import com.elira.academic.features.asignature.repository.AsignatureRepository;
import com.elira.academic.features.notes.dto.NoteDTO;
import com.elira.academic.features.notes.dto.NoteMapper;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.notes.repository.NoteRepository;
import com.elira.academic.features.reports.dto.AverageDTO;
import com.elira.academic.features.reports.dto.FinalReportDTO;
import com.elira.academic.features.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements IReportService {

    private final NoteRepository noteRepository;

    public ReportServiceImpl(
            NoteRepository noteRepository
    ) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<AverageDTO> average() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream()
                .collect(
                        Collectors.groupingBy(note ->
                                List.of(
                                        note.getStudent().getCourse().getName(),
                                        note.getAsignature().getName()
                                )
                        )
                )
                .entrySet()
                .stream()
                .map(entry -> {
                    var key = entry.getKey();
                    var average = entry.getValue().stream()
                            .mapToDouble(Note::getValue)
                            .average().orElse(0);
                    return new AverageDTO(key.get(0), key.get(1), average);
                })
                .toList();
    }

    @Override
    public List<NoteDTO> noteHistory(Long id) {
        return noteRepository.findByStudentId(id).stream()
                .map(NoteMapper::toDTO)
                .toList();
    }

    @Override
    public List<FinalReportDTO> finalReportByCourse(Long id) {
        return noteRepository.findByStudentCourseId(id).stream()
                .collect(Collectors.groupingBy(note ->
                        List.of(
                                note.getStudent().getUser().getName(),
                                note.getAsignature().getName()
                )))
                .entrySet()
                .stream()
                .map(entry -> {
                    var key = entry.getKey();
                    var average = entry.getValue().stream()
                            .mapToDouble(Note::getValue)
                            .average().orElse(0);
                    return new FinalReportDTO(key.get(0), key.get(1), average);
                })
                .toList();
    }
}
