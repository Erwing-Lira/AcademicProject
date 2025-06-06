package com.elira.academic.features.course.service;

import com.elira.academic.features.course.dto.CreateCourseDTO;
import com.elira.academic.features.course.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> findAll();
    Course create(CreateCourseDTO dto);
    Optional<Course> findById(Long id);
}
