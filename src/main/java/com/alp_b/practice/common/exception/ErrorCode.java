package com.alp_b.practice.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    EMAIL_ALREADY_EXIST(HttpStatus.BAD_REQUEST,  "This email already exists"),
    PASSWORD_NOT_MATCHED(HttpStatus.BAD_REQUEST,  "Password not matched"),
    INPUT_VALUE_MISSING(HttpStatus.BAD_REQUEST,  "Input value is missing"),

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,  "This member is not found"),
    CODE_GROUP_NOT_FOUND(HttpStatus.NOT_FOUND,  "This code group is not found"),
    CODE_DETAIL_NOT_FOUND(HttpStatus.NOT_FOUND,  "This code detail is not found"),
    DAY_NOT_FOUND(HttpStatus.NOT_FOUND,  "This day of the week is not found"),
    SERVICE_NOT_FOUND(HttpStatus.NOT_FOUND,  "This service is not found"),
    PET_SITTER_NOT_FOUND(HttpStatus.NOT_FOUND,  "This pet sitter is not found"),

    PASSWORD_HASHING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,  "Password hashing is failed"),;

    private final HttpStatus status;
    private final String message;
}
