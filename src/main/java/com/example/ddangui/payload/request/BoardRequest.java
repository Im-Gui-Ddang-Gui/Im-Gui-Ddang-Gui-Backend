package com.example.ddangui.payload.request;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.type.Type;
import com.example.ddangui.entity.type.enums.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {

    private String title;

    private String content;

    private List<Field> fields;

    private String userName;

    public Board toEntity(BoardRequest boardRequest) {
        return Board.builder()
                .reports(null)
                .isAccepted(false)
                .createdAt(LocalDateTime.now())
                .files(null)
                .content(boardRequest.getContent())
                .title(boardRequest.getTitle())
                .userName(boardRequest.getUserName())
                .type(null)
                .build();
    }

}
