package com.elira.academic.features.course.dto;

import com.elira.academic.features.asignature.dto.AsignatureDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDTO {
    private Long id;
    private String name;
    private String academicYear;
    private List<AsignatureDTO> asignatures;
}
