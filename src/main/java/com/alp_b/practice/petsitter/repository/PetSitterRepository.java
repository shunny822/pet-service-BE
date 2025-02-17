package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.PetSitter;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitter, Long> {
    @Query("SELECT p.id, m.name, p.address, p.pricePerHour " +
            "FROM PetSitter p " +
            "JOIN p.member m " +
            "WHERE p.active = true " +
            "AND p.address LIKE CONCAT('%', :location, '%')")
    List<Tuple> findByLocation(@Param("location") String location);

    @Query("SELECT p.id, m.name, m.email, m.phoneNumber, p.address, p.startTime, p.endTime, p.pricePerHour " +
            "FROM PetSitter p " +
            "JOIN p.member m " +
            "WHERE p.id = :petSitterId ")
    Tuple findDetailById(@Param("petSitterId") Long petSitterId);
}
