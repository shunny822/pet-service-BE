package com.alp_b.practice.codeGroup.dto;

import java.util.List;

public record CodeGroupListResponse(
        List<CodeGroupResponse> codeGroupList
) {
}
