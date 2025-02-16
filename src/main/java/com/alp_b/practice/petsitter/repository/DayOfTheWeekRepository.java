package com.alp_b.practice.petsitter.repository;

import com.alp_b.practice.petsitter.domain.DayOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfTheWeekRepository extends JpaRepository<DayOfTheWeek, Integer> {
}
