package com.example.ddangui.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardListResponse extends PageResponse {

    private List<BoardContentResponse> boardContentResponseList;

    @Builder
    public BoardListResponse(int totalElements, int totalPages, List<BoardContentResponse> boardContentResponseList) {
        super(totalElements, totalPages);
        this.boardContentResponseList = boardContentResponseList;
    }
}
