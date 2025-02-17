package com.alp_b.practice.petsitter.dto;

public record PetSitterPreviewResponse(
        Long id,
        String name,
        String address,
        Integer pricePerHour
) {
    public static PetSitterPreviewResponse of(Long id, String name, String address, Integer pricePerHour) {
        return new PetSitterPreviewResponse(id, name, address, pricePerHour);
    }
}
