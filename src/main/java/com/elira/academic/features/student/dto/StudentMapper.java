package com.elira.academic.features.student.dto;

import com.elira.academic.features.course.dto.CourseMapper;
import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.notes.dto.NoteMapper;
import com.elira.academic.features.student.model.Student;
import com.elira.academic.features.user.model.User;

import java.util.List;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getUser().getName())
                .email(student.getUser().getEmail())
                .course(CourseMapper.toDTO(student.getCourse()))
                .build();
    }

    public static Student toEntity(User user, Course course) {
        return Student.builder()
                .course(course)
                .user(user)
                .build();
    }
}
