package com.example.ddangui.service.board;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.board.BoardRepository;
import com.example.ddangui.entity.comment.CommentRepository;
import com.example.ddangui.entity.file.File;
import com.example.ddangui.entity.file.FileRepository;
import com.example.ddangui.entity.report.ReportRepository;
import com.example.ddangui.entity.type.Type;
import com.example.ddangui.entity.type.TypeRepository;
import com.example.ddangui.entity.type.enums.Field;
import com.example.ddangui.exception.BoardNotFoundException;
import com.example.ddangui.exception.PermissionMismatchException;
import com.example.ddangui.payload.request.BoardRequest;
import com.example.ddangui.payload.response.BoardContentResponse;
import com.example.ddangui.payload.response.BoardListResponse;
import com.example.ddangui.security.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final AuthenticationFacade authenticationFacade;

    private final BoardRepository boardRepository;
    private final TypeRepository typeRepository;
    private final ReportRepository reportRepository;
    private final FileRepository fileRepository;
    private final CommentRepository commentRepository;

    @Override
    public BoardListResponse getBoard(Pageable page) {
        Page<Board> boards = boardRepository.findAllByIsAcceptedTrue(page);
        return getBoardListResponse(boards);
    }

    @Override
    public BoardListResponse getFilterBoard(Field field, Pageable page) {
        Page<Board> boards = boardRepository.findAllByIsAcceptedTrueAndType(field, page);
        return getBoardListResponse(boards);
    }

    @Override
    public Long createBoard(BoardRequest request) {

        Board board = boardRepository.save(request.toEntity());

        for(Field field : request.getFields()) {
            typeRepository.save(
                    Type.builder()
                            .board(board)
                            .field(field)
                            .build()
            );
        }

        return board.getId();
    }

    @Override
    public void deleteBoard(Long boardId) {

        if(!authenticationFacade.isLogin()) {
            throw new PermissionMismatchException();
        }
        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        reportRepository.deleteByBoard(board);

        File file = fileRepository.findByBoard(board)
                .orElseThrow(BoardNotFoundException::new);
        // 파일삭제는 미래의 내가

        commentRepository.deleteAllByBoard(board);
        typeRepository.deleteAllByBoard(board);

    }


    private BoardListResponse getBoardListResponse(Page<Board> boards) {
        List<BoardContentResponse> response = new ArrayList<>();
        List<Field> fields = new ArrayList<>();

        for(Board board : boards) {
            for(Type type : board.getType()) {
                fields.add(type.getField());
            }

            response.add(
                    BoardContentResponse.builder()
                            .content(board.getContent())
                            .createdAt(board.getCreatedAt())
                            .userName(board.getUserName())
                            .id(board.getId())
                            .title(board.getTitle())
                            .fields(fields)
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
