package com.elira.academic.features.student.dto;

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
public class CreateStudentDTO {
    private String name;
    private String email;
    private String password;
    private List<Roles> roles;
    private Long courseId;
}
