package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.PossiblePetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossiblePetTypeRepository extends JpaRepository<PossiblePetType, Long> {
}
