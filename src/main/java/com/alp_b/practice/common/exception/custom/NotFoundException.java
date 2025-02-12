package com.alp_b.practice.common.exception.custom;

import com.alp_b.practice.common.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public NotFoundException(ErrorCode errorCode) {
      this.status = errorCode.getStatus();
      this.message = errorCode.getMessage();
    }

}
