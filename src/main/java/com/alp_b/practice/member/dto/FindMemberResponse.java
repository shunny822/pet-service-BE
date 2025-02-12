package com.alp_b.practice.member.dto;

import com.alp_b.practice.member.domain.Authority;
import com.alp_b.practice.member.domain.Member;

public record FindMemberResponse(
        String email,
        String name,
        String phoneNumber,
        Authority authority
) {

    public static FindMemberResponse from(Member member) {
        return new FindMemberResponse(
                member.getEmail(),
                member.getName(),
                member.getPhoneNumber(),
                member.getAuthority()
        );
    }

}
