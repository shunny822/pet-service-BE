package com.alp_b.practice.common.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String message) {
}
