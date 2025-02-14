package com.alp_b.practice.petsitter.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PossibleDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetSitter petSitter;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private DayOfTheWeek dayOfTheWeek;

    @Builder
    public PossibleDay(PetSitter petSitter, DayOfTheWeek dayOfTheWeek) {
        this.petSitter = petSitter;
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
