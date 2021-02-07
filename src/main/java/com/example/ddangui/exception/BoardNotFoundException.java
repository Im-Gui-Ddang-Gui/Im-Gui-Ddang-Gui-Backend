package com.example.ddangui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Board Not Found")
public class BoardNotFoundException extends RuntimeException {
}
