package com.elira.academic.features.professor.dto;

import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.professor.model.Professor;
import com.elira.academic.features.user.model.User;

import java.util.List;

public class ProfessorMapper {
    public static ProfessorDTO toDTO(Professor professor) {
        return ProfessorDTO.builder()
                .id(professor.getId())
                .specialty(professor.getSpecialty())
                .name(professor.getUser().getName())
                .email(professor.getUser().getEmail())
                .asignatures(
                        professor.getAsignatures() != null
                                ? professor.getAsignatures().stream()
                                .map(AsignatureMapper::toDTO)
                                .toList() : List.of()
                )
                .build();
    }

    public static Professor toEntity(CreateProfessorDTO dto, User user) {
        return Professor.builder()
                .specialty(dto.getSpecialty())
                .user(user)
                .build();
    }
}
