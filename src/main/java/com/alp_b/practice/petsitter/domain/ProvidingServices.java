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
public class ProvidingServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetSitter petSitter;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetServices petServices;

    @Builder
    public ProvidingServices(PetSitter petSitter, PetServices petServices) {
        this.petSitter = petSitter;
        this.petServices = petServices;
    }
}
