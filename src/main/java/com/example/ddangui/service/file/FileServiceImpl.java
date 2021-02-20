package com.example.ddangui.service.file;

import com.example.ddangui.entity.board.Board;
import com.example.ddangui.entity.board.BoardRepository;
import com.example.ddangui.entity.file.FileRepository;
import com.example.ddangui.exception.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final BoardRepository boardRepository;

    @Override
    public void uploadFile(Long boardId, MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        File dest = new File("/home/hong/files/ddangui/" + UUID.randomUUID() + fileName);
        file.transferTo(dest);

        fileRepository.save(
                com.example.ddangui.entity.file.File.builder()
                        .board(board)
                        .path(dest.getPath())
                        .build()
        );
    }
}

