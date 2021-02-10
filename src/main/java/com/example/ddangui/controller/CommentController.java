package com.example.ddangui.controller;

import com.example.ddangui.payload.request.CommentRequest;
import com.example.ddangui.payload.response.CommentListResponse;
import com.example.ddangui.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment/{boardId}")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{boardId}")
    public CommentListResponse getComment(@PathVariable Long boardId,
                                          Pageable page) {
        return commentService.getCommentList(boardId, page);
    }

    @PostMapping("/{boardId}")
    public void createComment(@PathVariable Long boardId,
                              @RequestBody CommentRequest commentRequest) {
        commentService.createComment(boardId, commentRequest);
    }
}
