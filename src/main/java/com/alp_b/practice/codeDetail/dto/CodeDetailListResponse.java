package com.alp_b.practice.codeDetail.dto;

import java.util.List;

public record CodeDetailListResponse(
        List<CodeDetailResponse> codeDetailList
) {
}
