package com.alp_b.practice.codeDetail.repository;

import com.alp_b.practice.codeDetail.domain.CodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeDetailRepository extends JpaRepository<CodeDetail, Integer> {
}
