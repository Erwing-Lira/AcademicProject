package com.elira.academic.features.course.dto;

import com.elira.academic.features.asignature.dto.AsignatureDTO;
import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.course.model.Course;

import java.util.List;

public class CourseMapper {
    public static Course toEntity(CreateCourseDTO dto) {
        return Course.builder()
                .name(dto.getName())
                .academicYear(dto.getAcademicYear())
                .build();
    }

    public static CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .academicYear(course.getAcademicYear())
                .asignatures(
                        course.getAsignatures() != null
                                ? course.getAsignatures().stream()
                                .map(AsignatureMapper::toDTO)
                                .toList() : List.of()
                )
                .build();
    }
}
