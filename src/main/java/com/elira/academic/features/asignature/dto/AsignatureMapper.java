package com.elira.academic.features.asignature.dto;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.notes.dto.NoteMapper;
import com.elira.academic.features.professor.model.Professor;

public class AsignatureMapper {
    public static AsignatureDTO toDTO(Asignature asignature) {
        AsignatureDTO dto = new AsignatureDTO();
        dto.setId(asignature.getId());
        dto.setName(asignature.getName());
        return dto;
    }

    public static Asignature toEntity(
            CreateAsignatureDTO dto,
            Professor professor,
            Course course)
    {
        return Asignature.builder()
                .name(dto.getName())
                .professor(professor)
                .course(course)
                .build();
    }
}
