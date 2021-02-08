package com.example.ddangui.service.comment;

import com.example.ddangui.payload.request.CommentRequest;
import com.example.ddangui.payload.response.CommentListResponse;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    CommentListResponse getCommentList(Long boardId, Pageable page);

    void createComment(Long boardId, CommentRequest commentRequest);

}
