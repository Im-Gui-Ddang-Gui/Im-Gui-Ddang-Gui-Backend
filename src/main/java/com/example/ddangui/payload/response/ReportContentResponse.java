package com.example.ddangui.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportContentResponse {

    private Long boardId;

    private Long reportId;

    private String title;

    private String content;

    private LocalDateTime createdAt;
}
