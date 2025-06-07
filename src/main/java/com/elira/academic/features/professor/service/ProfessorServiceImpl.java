package com.elira.academic.features.professor.service;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.professor.dto.CreateProfessorDTO;
import com.elira.academic.features.professor.dto.ProfessorMapper;
import com.elira.academic.features.professor.model.Professor;
import com.elira.academic.features.professor.repository.ProfessorRepository;
import com.elira.academic.features.user.model.User;
import com.elira.academic.features.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService {
    private final ProfessorRepository professorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ProfessorServiceImpl(
            ProfessorRepository professorRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.professorRepository = professorRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Professor create(CreateProfessorDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(dto.getRoles());

        User userSave = userRepository.save(user);
        Professor professor = ProfessorMapper.toEntity(dto, userSave);
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> seeDetail(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public Optional<List<Asignature>> listAsignatures(Long id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);

        if (professorOptional.isPresent()) {
            return Optional.of(professorOptional.get().getAsignatures());
        }
        return Optional.empty();
    }
}
