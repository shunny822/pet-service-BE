package com.alp_b.practice.pet.repository;

import com.alp_b.practice.pet.domain.PetClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetClassificationRepository extends JpaRepository<PetClassification, Integer> {
}
