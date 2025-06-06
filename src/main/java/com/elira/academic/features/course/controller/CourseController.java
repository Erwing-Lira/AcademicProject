package com.elira.academic.features.course.controller;

import com.elira.academic.features.course.dto.CourseMapper;
import com.elira.academic.features.course.dto.CreateCourseDTO;
import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.course.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final ICourseService courseService;

    public CourseController(
            ICourseService courseService
    ) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody CreateCourseDTO course
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        CourseMapper.toDTO(
                                courseService.create(course)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                courseService.findAll().stream()
                        .map(CourseMapper::toDTO)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id
    ) {
        Optional<Course> optionalCourse = courseService.findById(id);
        if (optionalCourse.isPresent()) {
            return ResponseEntity.ok(
                    CourseMapper.toDTO(optionalCourse.get())
            );
        }
        return ResponseEntity.notFound().build();
    }
}
