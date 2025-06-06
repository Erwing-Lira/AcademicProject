package com.elira.academic.features.reports.service;

import com.elira.academic.features.notes.dto.NoteDTO;
import com.elira.academic.features.reports.dto.AverageDTO;
import com.elira.academic.features.reports.dto.FinalReportDTO;

import java.util.List;

public interface IReportService {
    List<AverageDTO> average();
    List<NoteDTO> noteHistory(Long id);
    List<FinalReportDTO> finalReportByCourse(Long id);
}
