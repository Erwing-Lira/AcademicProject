package com.elira.academic.features.material.service;

import com.elira.academic.features.material.dto.CreateMaterialDTO;
import com.elira.academic.features.material.model.Material;

import java.util.Optional;

public interface IMaterialService {
    Material create(CreateMaterialDTO dto);
    Optional<Material> findById(Long id);
    Optional<Material> deleteById(Long id);
}
