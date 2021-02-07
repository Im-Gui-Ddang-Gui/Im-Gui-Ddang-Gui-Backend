package com.example.ddangui.service.comment;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.board.BoardRepository;
import com.example.ddangui.entity.comment.Comment;
import com.example.ddangui.entity.comment.CommentRepository;
import com.example.ddangui.exception.BoardNotFoundException;
import com.example.ddangui.payload.response.CommentContentResponse;
import com.example.ddangui.payload.response.CommentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public CommentListResponse getCommentList(Long boardId, Pageable page) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        Page<Comment> comments = commentRepository.findAllByBoard(board, page);
        List<CommentContentResponse> commentContentResponseList = new ArrayList<>();

        for(Comment comment : comments) {
            commentContentResponseList.add(
                    CommentContentResponse.builder()
                            .content(comment.getContent())
                            .id(comment.getId())
                            .createdAt(comment.getCreatedAt())
                            .userName(comment.getUserName())
                            .build()
            );
        }

        return CommentListResponse.builder()
                .commentContentResponseList(commentContentResponseList)
                .totalElements((int)comments.getTotalElements())
                .totalPages(comments.getTotalPages())
                .build();

    }

}
