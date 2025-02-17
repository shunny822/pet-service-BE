package com.alp_b.practice.petsitter.dto;

import com.alp_b.practice.petsitter.domain.DayOfTheWeek;

public record PossibleDayResponse(Integer id, String dayName) {

    public static PossibleDayResponse from(DayOfTheWeek dayOfTheWeek) {
        return new PossibleDayResponse(dayOfTheWeek.getId(), dayOfTheWeek.getDayName());
    }
}
