package com.elira.academic.features.student.service;

import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.course.repository.CourseRepository;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.student.dto.CreateStudentDTO;
import com.elira.academic.features.student.dto.StudentMapper;
import com.elira.academic.features.student.model.Student;
import com.elira.academic.features.student.repository.StudentRepository;
import com.elira.academic.features.user.model.User;
import com.elira.academic.features.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentServiceImpl(
            StudentRepository studentRepository,
            UserRepository userRepository,
            CourseRepository courseRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Student create(CreateStudentDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(dto.getRoles());

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow();

        User userSave = userRepository.save(user);
        Student student = StudentMapper.toEntity(userSave, course);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<List<Note>> findNotesById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            return Optional.of(optionalStudent.get().getNotes());
        }

        return Optional.empty();
    }
}
