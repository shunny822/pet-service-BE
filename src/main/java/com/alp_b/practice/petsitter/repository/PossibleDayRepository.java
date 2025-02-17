package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.DayOfTheWeek;
import com.alp_b.practice.petsitter.domain.PossibleDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossibleDayRepository extends JpaRepository<PossibleDay, Long> {
    @Query("SELECT d " +
            "FROM PossibleDay p " +
            "JOIN p.dayOfTheWeek d " +
            "WHERE p.petSitter.id = :petSitterId")
    List<DayOfTheWeek> findAllDayOfTheWeekByPetSitterId(@Param("petSitterId") Long petSitterId);
}
