package com.alp_b.practice.petsitter.dto;

import java.util.List;

public record PetSitterListResponse(
        List<PetSitterPreviewResponse> petSitterList
) {
}
