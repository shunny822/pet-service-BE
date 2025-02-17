package com.alp_b.practice.codeGroup.domain;

import com.alp_b.practice.common.jpa.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CodeGroup extends BaseTimeEntity {
    @Id
    private Integer id;

    @NotNull
    private String classification;

    @Builder
    public CodeGroup(Integer id, String classification) {
        this.id = id;
        this.classification = classification;
    }
}
