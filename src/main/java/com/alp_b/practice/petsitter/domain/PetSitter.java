package com.alp_b.practice.petsitter.domain;

import com.alp_b.practice.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PetSitter {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Member member;

    @NotBlank
    private String address;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    private Integer pricePerHour;

    @NotNull
    private boolean active = Boolean.FALSE;

    @Builder
    public PetSitter(Long id, Member member, String address, LocalTime startTime, LocalTime endTime, Integer pricePerHour) {
        this.id = id;
        this.member = member;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pricePerHour = pricePerHour;
    }
}
