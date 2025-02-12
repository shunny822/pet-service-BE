package com.alp_b.practice.auth.service.impl;

import com.alp_b.practice.auth.dto.LoginRequest;
import com.alp_b.practice.auth.service.AuthService;
import com.alp_b.practice.common.exception.ErrorCode;
import com.alp_b.practice.common.exception.custom.BadRequestException;
import com.alp_b.practice.common.exception.custom.NotFoundException;
import com.alp_b.practice.member.domain.Member;
import com.alp_b.practice.member.repository.MemberRepository;
import com.alp_b.practice.member.util.PasswordHashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
    private final MemberRepository memberRepository;
    private final PasswordHashing passwordHashing;

    @Override
    public Member login(LoginRequest loginRequest) {
        Optional<Member> member = memberRepository.findByEmail(loginRequest.email());

        if (member.isEmpty()) {
            throw new NotFoundException(ErrorCode.MEMBER_NOT_FOUND);
        }

        String hashedPassword = passwordHashing.hashPassword(loginRequest.password());

        if (!member.get().getPassword().equals(hashedPassword)) {
            throw new BadRequestException(ErrorCode.PASSWORD_NOT_MATCHED);
        }

        return member.get();
    }
}
