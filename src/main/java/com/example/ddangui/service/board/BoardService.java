package com.example.ddangui.service.board;

import com.example.ddangui.entity.type.enums.Types;
import com.example.ddangui.payload.request.BoardRequest;
import com.example.ddangui.payload.response.BoardListResponse;

public interface BoardService {
    BoardListResponse getBoard();

    BoardListResponse getFilterBoard(Types types);

    Long createBoard(BoardRequest request);

}
