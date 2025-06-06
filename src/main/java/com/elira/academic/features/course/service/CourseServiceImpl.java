package com.elira.academic.features.course.service;

import com.elira.academic.features.course.dto.CourseMapper;
import com.elira.academic.features.course.dto.CreateCourseDTO;
import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(
            CourseRepository courseRepository
    ) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course create(CreateCourseDTO dto) {
        return courseRepository.save(
                CourseMapper.toEntity(dto)
        );
    }
}
