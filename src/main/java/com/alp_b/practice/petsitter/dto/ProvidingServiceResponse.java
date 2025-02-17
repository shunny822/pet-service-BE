package com.alp_b.practice.petsitter.dto;

import com.alp_b.practice.petsitter.domain.PetService;

public record ProvidingServiceResponse(Integer id, String type) {

    public static ProvidingServiceResponse from(PetService petService) {
        return new ProvidingServiceResponse(petService.getId(), petService.getType());
    }
}
