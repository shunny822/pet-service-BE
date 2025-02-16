package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.ProvidingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidingServiceRepository extends JpaRepository<ProvidingService, Long> {
}
