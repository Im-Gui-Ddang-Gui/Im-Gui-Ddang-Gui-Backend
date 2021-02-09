package com.example.ddangui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Permission Mismatch Exception")
public class PermissionMismatchException extends RuntimeException {
}
