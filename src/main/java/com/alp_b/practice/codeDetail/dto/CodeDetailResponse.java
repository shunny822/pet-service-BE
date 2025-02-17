package com.alp_b.practice.codeDetail.dto;

import com.alp_b.practice.codeDetail.domain.CodeDetail;

public record CodeDetailResponse(
        Integer code,
        String breed
) {
    public static CodeDetailResponse from(CodeDetail codeDetail) {
        return new CodeDetailResponse(codeDetail.getCode(), codeDetail.getBreed());
    }
}
