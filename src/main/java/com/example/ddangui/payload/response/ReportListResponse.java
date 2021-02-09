package com.example.ddangui.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ReportListResponse extends PageResponse {
    private List<ReportContentResponse> reportContentResponses;

    @Builder
    public ReportListResponse(int totalElements, int totalPages, List<ReportContentResponse> reportContentResponses) {
        super(totalElements, totalPages);
        this.reportContentResponses = reportContentResponses;
    }
}
