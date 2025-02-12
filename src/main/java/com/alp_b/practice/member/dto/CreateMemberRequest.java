package com.alp_b.practice.member.dto;

public record CreateMemberRequest(
        String email,
        String password1,
        String password2,
        String name,
        String phoneNumber
) {
}
