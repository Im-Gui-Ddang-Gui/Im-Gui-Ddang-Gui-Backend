package com.example.ddangui.service.board;

import com.example.ddangui.entity.type.enums.Field;
import com.example.ddangui.payload.request.BoardRequest;
import com.example.ddangui.payload.response.BoardListResponse;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    BoardListResponse getBoard(Pageable page);

    BoardListResponse getFilterBoard(Field field, Pageable page);

    Long createBoard(BoardRequest request);

    void deleteBoard(Long boardId);

    void acceptBoard(Long boardId);

}
