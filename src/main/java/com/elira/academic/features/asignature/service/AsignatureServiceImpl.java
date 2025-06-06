package com.elira.academic.features.asignature.service;

import com.elira.academic.features.asignature.dto.AsignatureMapper;
import com.elira.academic.features.asignature.dto.CreateAsignatureDTO;
import com.elira.academic.features.asignature.dto.EditAsignatureDTO;
import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.asignature.repository.AsignatureRepository;
import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.course.repository.CourseRepository;
import com.elira.academic.features.professor.model.Professor;
import com.elira.academic.features.professor.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignatureServiceImpl implements IAsignatureService{
    private final AsignatureRepository asignatureRepository;
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public AsignatureServiceImpl(
            AsignatureRepository asignatureRepository,
            ProfessorRepository professorRepository,
            CourseRepository courseRepository
    ) {
        this.asignatureRepository = asignatureRepository;
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Asignature create(CreateAsignatureDTO dto) {
        Professor professor = professorRepository.findById(dto.getProfessorId())
                        .orElseThrow();
        Course course = courseRepository.findById(dto.getCourseId())
                        .orElseThrow();

        Asignature asignature = AsignatureMapper.toEntity(dto, professor, course);
        return asignatureRepository.save(asignature);
    }

    @Override
    public List<Asignature> findAll() {
        return asignatureRepository.findAll();
    }

    @Override
    public Optional<Asignature> findById(Long id) {
        return asignatureRepository.findById(id);
    }

    @Override
    public Optional<Asignature> editById(Long id, EditAsignatureDTO dto) {
        Optional<Asignature> asignatureOptional = asignatureRepository.findById(id);

        if (asignatureOptional.isPresent()) {
            Asignature newAsignature = asignatureOptional.get();

            if (dto.getName() != null) {
                newAsignature.setName(dto.getName());
            }
            return Optional.of(asignatureRepository.save(newAsignature));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Asignature> deleteById(Long id) {
        Optional<Asignature> asignatureOptional = asignatureRepository.findById(id);
        asignatureOptional.ifPresent(asignatureRepository::delete);
        return asignatureOptional;
    }
}
