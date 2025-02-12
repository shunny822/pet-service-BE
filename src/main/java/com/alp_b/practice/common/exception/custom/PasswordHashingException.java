package com.alp_b.practice.common.exception.custom;

import com.alp_b.practice.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class PasswordHashingException extends RuntimeException {
  private final HttpStatus status;
  private final String message;

  public PasswordHashingException(ErrorCode errorCode) {
    this.status = errorCode.getStatus();
    this.message = errorCode.getMessage();
  }
}
