package com.alp_b.practice.codeGroup.repository;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupRepository extends JpaRepository<CodeGroup, Integer> {
}
