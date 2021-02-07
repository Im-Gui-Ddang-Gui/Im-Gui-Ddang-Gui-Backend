package com.example.ddangui.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentListResponse extends PageResponse {

    private List<CommentContentResponse> commentContentResponseList;

    @Builder
    public CommentListResponse(int totalElements, int totalPages, List<CommentContentResponse> commentContentResponseList) {
        super(totalElements, totalPages);
        this.commentContentResponseList = commentContentResponseList;
    }
}
