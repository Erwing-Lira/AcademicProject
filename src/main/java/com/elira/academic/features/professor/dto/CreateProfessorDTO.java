package com.elira.academic.features.professor.dto;

import com.elira.academic.features.roles.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProfessorDTO {
    private String specialty;
    private String name;
    private String email;
    private String password;
    private List<Roles> roles;
}
