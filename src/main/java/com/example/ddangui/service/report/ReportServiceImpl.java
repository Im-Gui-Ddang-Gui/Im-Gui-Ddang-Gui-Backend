package com.example.ddangui.service.report;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.board.BoardRepository;
import com.example.ddangui.entity.report.Report;
import com.example.ddangui.entity.report.ReportRepository;
import com.example.ddangui.exception.AlreadyReportException;
import com.example.ddangui.exception.BoardNotFoundException;
import com.example.ddangui.exception.PermissionMismatchException;
import com.example.ddangui.payload.response.ReportContentResponse;
import com.example.ddangui.payload.response.ReportListResponse;
import com.example.ddangui.security.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final BoardRepository boardRepository;
    private final ReportRepository reportRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void createReport(Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        if(reportRepository.findByBoard(board).isEmpty()) {
            throw new AlreadyReportException();
        }

        reportRepository.save(
                Report.builder()
                        .createdAt(LocalDateTime.now())
                        .board(board)
                        .build()
        );

    }

    @Override
    public void deleteReport(Long reportId) {
        if(!authenticationFacade.isLogin()) {
            throw new PermissionMismatchException();
        }
        reportRepository.deleteById(reportId);
    }

    @Override
    public ReportListResponse getReportList(Pageable page) {
        if(!authenticationFacade.isLogin()) {
            throw new PermissionMismatchException();
        }

        Page<Report> reportList = reportRepository.findAllBy(page);
        List<ReportContentResponse> reportContentResponses = new ArrayList<>();

        for(Report report : reportList) {
            reportContentResponses.add(
                    ReportContentResponse.builder()
                            .reportId(report.getId())
                            .content(report.getBoard().getContent())
                            .title(report.getBoard().getTitle())
                            .boardId(report.getBoard().getId())
                            .createdAt(report.getCreatedAt())
                            .build()
            );
        }

        return ReportListResponse.builder()
                .reportContentResponses(reportContentResponses)
                .totalElements((int)reportList.getTotalElements())
                .totalPages(reportList.getTotalPages())
                .build();
    }


}
