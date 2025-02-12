package com.alp_b.practice.member.dto;

public record CreateMemberResponse(Long memberId) {

    public static CreateMemberResponse of(Long memberId) {
        return new CreateMemberResponse(memberId);
    }

}
