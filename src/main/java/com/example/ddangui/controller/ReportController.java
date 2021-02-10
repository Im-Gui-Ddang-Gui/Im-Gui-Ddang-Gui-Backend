package com.example.ddangui.controller;

import com.example.ddangui.payload.response.ReportListResponse;
import com.example.ddangui.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/{boardId}")
    public void createBoard(@PathVariable Long boardId) {
        reportService.createReport(boardId);
    }

    @DeleteMapping("/{reportId}")
    public void deleteBoard(@PathVariable Long reportId) {
        reportService.deleteReport(reportId);
    }

    @GetMapping
    public ReportListResponse getReportList(Pageable page) {
        return reportService.getReportList(page);
    }

}
