package com.alp_b.practice.petsitter.dto;

import com.alp_b.practice.codeGroup.domain.CodeGroup;

public record PossiblePetTypeResponse(Integer id, String classification) {

    public static PossiblePetTypeResponse from(CodeGroup codeGroup) {
        return new PossiblePetTypeResponse(codeGroup.getId(), codeGroup.getClassification());
    }
}
