package com.elira.academic.features.notes.model;

import com.elira.academic.features.asignature.model.Asignature;
import com.elira.academic.features.period.model.PeriodoLectivo;
import com.elira.academic.features.student.model.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Max(value = 10)
    @Min(value = 0)
    private Double value;

    @NotBlank
    private String observations;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "asignature_id")
    private Asignature asignature;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private PeriodoLectivo periodoLectivo;
}
