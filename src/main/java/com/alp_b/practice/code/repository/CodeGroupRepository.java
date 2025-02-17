package com.alp_b.practice.code.repository;

import com.alp_b.practice.code.domain.CodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupRepository extends JpaRepository<CodeGroup, Integer> {
}
