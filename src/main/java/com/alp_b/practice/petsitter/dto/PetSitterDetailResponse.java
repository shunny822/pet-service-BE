package com.alp_b.practice.petsitter.dto;

import java.time.LocalTime;
import java.util.List;

public record PetSitterDetailResponse(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String address,
        LocalTime startTime,
        LocalTime endTime,
        Integer pricePerHour,
        List<PossiblePetTypeResponse> possiblePetTypes,
        List<PossibleDayResponse> possibleDays,
        List<ProvidingServiceResponse> providingServices
) {
    public static PetSitterDetailResponse of(
            Long id,
            String name,
            String email,
            String phoneNumber,
            String address,
            LocalTime startTime,
            LocalTime endTime,
            Integer pricePerHour,
            List<PossiblePetTypeResponse> possiblePetTypes,
            List<PossibleDayResponse> possibleDays,
            List<ProvidingServiceResponse> providingServices
    ) {
        return new PetSitterDetailResponse(
                id,
                name,
                email,
                phoneNumber,
                address,
                startTime,
                endTime,
                pricePerHour,
                possiblePetTypes,
                possibleDays,
                providingServices
        );
    }
}
