package com.example.ddangui.controller;

import com.example.ddangui.entity.type.enums.Types;
import com.example.ddangui.payload.response.BoardListResponse;
import com.example.ddangui.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public BoardListResponse getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/{types}")
    public BoardListResponse getFilterBoard(@PathVariable Types types) {
        return boardService.getFilterBoard(types);
    }
//
//    @PostMapping
//    public Long

}
