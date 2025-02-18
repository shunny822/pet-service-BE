package com.alp_b.practice.member.service.impl;

import com.alp_b.practice.common.exception.ErrorCode;
import com.alp_b.practice.common.exception.custom.BadRequestException;
import com.alp_b.practice.member.domain.Member;
import com.alp_b.practice.member.dto.CreateMemberRequest;
import com.alp_b.practice.member.repository.AuthorityRepository;
import com.alp_b.practice.member.repository.MemberRepository;
import com.alp_b.practice.member.service.MemberService;
import com.alp_b.practice.member.util.PasswordHashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordHashing passwordHashing;

    private static final int DEFAULT_AUTHORITY_ID = 1;

    @Override
    public Long createMember(CreateMemberRequest createMemberRequest) {
        String email = verifyUniqueEmail(createMemberRequest.email());
        String password = verifyPassword(createMemberRequest.password1(), createMemberRequest.password2());

        Member member = Member.builder()
                .email(email)
                .name(createMemberRequest.name())
                .password(passwordHashing.hashPassword(password))
                .phoneNumber(createMemberRequest.phoneNumber())
                .authority(authorityRepository.findById(DEFAULT_AUTHORITY_ID))
                .build();

        return memberRepository.save(member).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isEmpty()) {
            throw new BadRequestException(ErrorCode.MEMBER_NOT_FOUND);
        }

        return member.get();
    }

    private String verifyUniqueEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new BadRequestException(ErrorCode.EMAIL_ALREADY_EXIST);
        }

        return email;
    }

    private String verifyPassword(String password1, String password2) {
        if (!password1.equals(password2)) {
            throw new BadRequestException(ErrorCode.PASSWORD_NOT_MATCHED);
        }

        return password1;
    }
}
