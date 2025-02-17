package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.PetService;
import com.alp_b.practice.petsitter.domain.ProvidingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvidingServiceRepository extends JpaRepository<ProvidingService, Long> {
    @Query("SELECT ps " +
            "FROM ProvidingService p " +
            "JOIN p.petService ps " +
            "WHERE p.petSitter.id = :petSitterId")
    List<PetService> findAllPetServiceByPetSitterId(@Param("petSitterId") Long petSitterId);
}
