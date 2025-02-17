package com.alp_b.practice.codeGroup.service.impl;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.repository.CodeGroupRepository;
import com.alp_b.practice.codeGroup.service.CodeGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CodeGroupServiceImpl implements CodeGroupService {
    private final CodeGroupRepository codeGroupRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CodeGroup> findAllCodeGroup() {
        return codeGroupRepository.findAll();
    }
}
