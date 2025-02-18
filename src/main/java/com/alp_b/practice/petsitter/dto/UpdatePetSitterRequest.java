package com.alp_b.practice.petsitter.dto;

import java.time.LocalTime;
import java.util.List;

public record UpdatePetSitterRequest(
        String address,
        LocalTime startTime,
        LocalTime endTime,
        Integer pricePerHour,
        List<Integer> possibleDays,
        List<Integer> possiblePetTypes,
        List<Integer> providingServices
) {
}
