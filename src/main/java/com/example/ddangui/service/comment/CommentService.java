package com.example.ddangui.service.comment;

import com.example.ddangui.payload.response.CommentListResponse;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    CommentListResponse getCommentList(Long boardId, Pageable page);

}
