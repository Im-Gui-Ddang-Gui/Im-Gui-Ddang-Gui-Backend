package com.example.ddangui.entity.report;

import com.example.ddangui.entity.board.Board;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report_tbl")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "boardId")
    private Board board;
}
