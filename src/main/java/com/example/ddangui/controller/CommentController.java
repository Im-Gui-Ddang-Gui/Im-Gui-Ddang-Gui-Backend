package com.example.ddangui.controller;

import com.example.ddangui.payload.response.CommentListResponse;
import com.example.ddangui.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{boardId}")
    public CommentListResponse getComment(@PathVariable Long boardId,
                                          Pageable page) {
        return commentService.getCommentList(boardId, page);
    }
}
