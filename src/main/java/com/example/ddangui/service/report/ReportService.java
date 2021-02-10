package com.example.ddangui.service.report;

import com.example.ddangui.payload.response.ReportListResponse;

import org.springframework.data.domain.Pageable;

public interface ReportService {
    void createReport(Long boardId);

    void deleteReport(Long reportId);

    ReportListResponse getReportList(Pageable page);

}
