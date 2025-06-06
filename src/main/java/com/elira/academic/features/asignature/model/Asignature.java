package com.elira.academic.features.asignature.model;

import com.elira.academic.features.course.model.Course;
import com.elira.academic.features.material.model.Material;
import com.elira.academic.features.notes.model.Note;
import com.elira.academic.features.professor.model.Professor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "asignatures")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Asignature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "asignature")
    private List<Material> materiales;

    @OneToMany(mappedBy = "asignature")
    private List<Note> notes;
}
