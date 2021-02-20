package com.example.ddangui.entity.board;

import com.example.ddangui.entity.comment.Comment;
import com.example.ddangui.entity.file.File;
import com.example.ddangui.entity.report.Report;
import com.example.ddangui.entity.type.Type;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board_tbl")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String userName;

    private Boolean isAccepted;

    @DateTimeFormat(pattern = "yyyy-MM-dd`T`hh:mm:SS")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "board")
    @JsonBackReference
    private List<Type> type;

    @OneToOne(mappedBy = "board")
    @JsonBackReference
    private File files;

    @OneToMany(mappedBy = "board")
    @JsonBackReference
    private List<Report> reports;

    @OneToMany(mappedBy = "board")
    @JsonBackReference
    private List<Comment> comments;

    public Board accept() {
        this.isAccepted = true;
        return this;
    }

}
