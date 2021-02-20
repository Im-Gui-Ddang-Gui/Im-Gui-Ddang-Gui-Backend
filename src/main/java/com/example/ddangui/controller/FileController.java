package com.example.ddangui.controller;

import com.example.ddangui.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/{boardId}")
    public void createFile(@PathVariable Long boardId,
                           @RequestParam MultipartFile file) throws Exception {
        fileService.uploadFile(boardId, file);
    }
}
