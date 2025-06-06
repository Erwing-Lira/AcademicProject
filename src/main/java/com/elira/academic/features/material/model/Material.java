package com.elira.academic.features.material.model;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.professor.model.Professor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Column(name = "url_file")
    @NotBlank
    private String urlFile;

    @ManyToOne
    @JoinColumn(name = "asignature_id")
    private Asignature asignature;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
