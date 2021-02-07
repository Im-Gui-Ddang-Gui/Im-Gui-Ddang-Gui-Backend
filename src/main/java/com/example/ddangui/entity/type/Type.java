package com.example.ddangui.entity.type;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.type.enums.Field;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "type_tbl")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Field field;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "boardId")
    private Board board;
}
