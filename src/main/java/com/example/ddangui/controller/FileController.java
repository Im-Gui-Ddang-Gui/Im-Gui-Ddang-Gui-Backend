package com.example.ddangui.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    @PostMapping("/{boardId}")
    public void createFile(@PathVariable Long boardId,
                           @RequestParam MultipartFile file) {

    }
}
