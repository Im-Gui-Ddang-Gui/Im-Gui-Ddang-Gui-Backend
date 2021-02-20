package com.example.ddangui.controller;

import com.example.ddangui.entity.type.enums.Field;
import com.example.ddangui.payload.request.BoardRequest;
import com.example.ddangui.payload.response.BoardListResponse;
import com.example.ddangui.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public BoardListResponse getBoard(Pageable page) {
        return boardService.getBoard(page);
    }

    @GetMapping("/{field}")
    public BoardListResponse getFilterBoard(@PathVariable Field field,
                                            Pageable page) {
        return boardService.getFilterBoard(field, page);
    }

    @PostMapping
    public Long createBoard(@RequestBody BoardRequest boardRequest) {
        return boardService.createBoard(boardRequest);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }

    @PatchMapping("/{boardId}")
    public void acceptBoard(@PathVariable Long boardId) {
        boardService.acceptBoard(boardId);
    }

}
