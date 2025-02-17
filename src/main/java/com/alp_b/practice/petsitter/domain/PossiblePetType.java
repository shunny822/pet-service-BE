package com.alp_b.practice.petsitter.domain;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
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
    private CodeGroup codeGroup;

    @Builder
    public PossiblePetType(PetSitter petSitter, CodeGroup codeGroup) {
        this.petSitter = petSitter;
        this.codeGroup = codeGroup;
    }
}
