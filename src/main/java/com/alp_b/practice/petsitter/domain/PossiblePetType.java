package com.alp_b.practice.petsitter.domain;

import com.alp_b.practice.pet.domain.PetClassification;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PossiblePetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetSitter petSitter;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PetClassification petClassification;

    @Builder
    public PossiblePetType(PetSitter petSitter, PetClassification petClassification) {
        this.petSitter = petSitter;
        this.petClassification = petClassification;
    }
}
