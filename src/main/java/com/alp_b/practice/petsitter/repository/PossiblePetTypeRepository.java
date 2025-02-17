package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.petsitter.domain.PossiblePetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossiblePetTypeRepository extends JpaRepository<PossiblePetType, Long> {
    @Query("SELECT c " +
            "FROM PossiblePetType p " +
            "JOIN p.codeGroup c " +
            "WHERE p.petSitter.id = :petSitterId ")
    List<CodeGroup> findAllPossiblePetTypeByPetSitterId(@Param("petSitterId") Long petSitterId);
}
