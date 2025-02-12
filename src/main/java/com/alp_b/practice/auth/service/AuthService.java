package com.alp_b.practice.auth.service;

import com.alp_b.practice.auth.dto.LoginRequest;
import com.alp_b.practice.member.domain.Member;

public interface AuthService {
    Member login(LoginRequest loginRequest);
}
