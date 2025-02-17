package com.alp_b.practice.codeGroup.dto;

import com.alp_b.practice.codeGroup.domain.CodeGroup;

public record CodeGroupResponse(
        Integer id,
        String classification
) {

    public static CodeGroupResponse from(CodeGroup codeGroup) {
        return new CodeGroupResponse(codeGroup.getId(), codeGroup.getClassification());
    }
}
