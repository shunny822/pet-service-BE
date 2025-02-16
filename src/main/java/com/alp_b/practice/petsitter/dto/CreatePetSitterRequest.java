package com.alp_b.practice.petsitter.dto;

import java.time.LocalTime;

public record CreatePetSitterRequest(
        Long memberId,
        String address,
        String possiblePetTypes,
        String possibleDays,
        String providingServices,
        LocalTime startTime,
        LocalTime endTime,
        Integer pricePerHour
) {
}
