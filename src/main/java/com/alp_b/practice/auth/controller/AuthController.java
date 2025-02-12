package com.alp_b.practice.auth.controller;

import com.alp_b.practice.auth.dto.LoginRequest;
import com.alp_b.practice.auth.service.AuthService;
import com.alp_b.practice.member.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        Member member = authService.login(loginRequest);
        HttpSession session = request.getSession();
        session.setAttribute("userId", member.getId());

        return ResponseEntity.ok("Login successful");
    }
}
