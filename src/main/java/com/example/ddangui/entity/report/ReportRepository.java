package com.example.ddangui.entity.report;

import com.example.ddangui.entity.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    Optional<Report> findByBoard(Board board);

    void deleteByBoard(Board board);

    Page<Report> findAllBy(Pageable page);
}
