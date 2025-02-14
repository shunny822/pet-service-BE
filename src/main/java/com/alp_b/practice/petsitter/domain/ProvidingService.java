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
public class ProvidingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetSitter petSitter;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetService petService;

    @Builder
    public ProvidingService(PetSitter petSitter, PetService petService) {
        this.petSitter = petSitter;
        this.petService = petService;
    }
}
