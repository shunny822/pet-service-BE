package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.PetSitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitter, Long> {
//    @Lock(LockModeType.OPTIMISTIC)
//    @Override
//    PetSitter save(PetSitter petSitter);
}
