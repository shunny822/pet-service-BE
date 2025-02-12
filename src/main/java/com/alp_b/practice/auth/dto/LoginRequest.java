package com.alp_b.practice.auth.dto;

import com.alp_b.practice.common.exception.ErrorCode;
import com.alp_b.practice.common.exception.custom.BadRequestException;

public record LoginRequest(String email, String password) {

    public LoginRequest(String email, String password) {
        if (email.equals("") || password.equals("")) {
            throw new BadRequestException(ErrorCode.INPUT_VALUE_MISSING);
        }

        this.email = email;
        this.password = password;
    }

}
