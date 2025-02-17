package com.alp_b.practice.codeDetail.domain;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.common.jpa.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CodeDetail extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @NotBlank
    private String breed;

    @NotNull
    @ManyToOne
    private CodeGroup codeGroup;

    @Builder
    public CodeDetail(String breed, CodeGroup codeGroup) {
        this.breed = breed;
        this.codeGroup = codeGroup;
    }
}
