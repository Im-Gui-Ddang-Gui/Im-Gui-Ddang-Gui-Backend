package com.example.ddangui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already Reported")
public class AlreadyReportException extends RuntimeException {
}
