package com.example.ddangui.service.board;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.board.BoardRepository;
import com.example.ddangui.entity.type.Type;
import com.example.ddangui.entity.type.enums.Types;
import com.example.ddangui.payload.request.BoardRequest;
import com.example.ddangui.payload.response.BoardContentResponse;
import com.example.ddangui.payload.response.BoardListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardListResponse getBoard() {
        Page<Board> boards = boardRepository.findAllByIsAcceptedTrue();
        return getBoardListResponse(boards);
    }

    @Override
    public BoardListResponse getFilterBoard(Types types) {
        Page<Board> boards = boardRepository.findAllByIsAcceptedTrueAndType(types);
        return getBoardListResponse(boards);
    }

    @Override
    public Long createBoard(BoardRequest request) {

        boardRepository.save(
                Board.builder()
                        .content(request.getContent())
                        .files(null)
                        .createdAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .isAccepted(false)
                        .reports(null)
                        .type(request.getTypes())
                        .build()
        )
    }


    private BoardListResponse getBoardListResponse(Page<Board> boards) {
        List<BoardContentResponse> response = new ArrayList<>();
        List<Types> type = new ArrayList<>();

        for(Board board : boards) {
            for(Type type1 : board.getType()) {
                type.add(type1.getTypes());
            }

            response.add(
                    BoardContentResponse.builder()
                            .content(board.getContent())
                            .createdAt(board.getCreatedAt())
                            .userName(board.getUserName())
                            .id(board.getId())
                            .title(board.getTitle())
                            .types(type)
                            .build()
            );
        }

        return BoardListResponse.builder()
                .boardContentResponseList(response)
                .totalElements((int)boards.getTotalElements())
                .totalPages(boards.getTotalPages())
                .build();
    }
}
