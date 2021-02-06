package com.example.ddangui.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse {

    private int totalElements;

    private int totalPages;
}
