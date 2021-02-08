package com.example.ddangui.payload.request;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {

    private String userName;

    private String content;

    public Comment toEntity(Board board) {
        return Comment.builder()
                .userName(userName)
                .content(content)
                .createdAt(LocalDateTime.now())
                .board(board)
                .build();
    }

}
