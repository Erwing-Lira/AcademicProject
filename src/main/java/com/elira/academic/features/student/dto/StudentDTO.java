package com.elira.academic.features.student.dto;

import com.elira.academic.features.course.dto.CourseDTO;
import com.elira.academic.features.notes.dto.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private CourseDTO course;
}
