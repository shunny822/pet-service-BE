package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.PetService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetServiceRepository extends JpaRepository<PetService, Integer> {
}
