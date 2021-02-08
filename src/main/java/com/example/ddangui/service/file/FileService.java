package com.example.ddangui.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    void uploadFile(Long boardId, MultipartFile file) throws Exception;
}
