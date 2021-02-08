package com.example.ddangui.service.report;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.board.BoardRepository;
import com.example.ddangui.entity.report.Report;
import com.example.ddangui.entity.report.ReportRepository;
import com.example.ddangui.exception.AlreadyReportException;
import com.example.ddangui.exception.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final BoardRepository boardRepository;
    private final ReportRepository reportRepository;

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
}
