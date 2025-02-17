package com.alp_b.practice.codeGroup.service.impl;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.dto.CreateCodeGroupRequest;
import com.alp_b.practice.codeGroup.repository.CodeGroupRepository;
import com.alp_b.practice.codeGroup.service.CodeGroupService;
import com.alp_b.practice.common.exception.ErrorCode;
import com.alp_b.practice.common.exception.custom.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void createCodeGroup(CreateCodeGroupRequest createCodeGroupRequest) {
        CodeGroup codeGroup = CodeGroup.builder()
                .id(createCodeGroupRequest.groupId())
                .classification(createCodeGroupRequest.classification())
                .build();

        codeGroupRepository.save(codeGroup);
    }

    @Override
    public void deleteCodeGroup(Integer codeGroupId) {
        Optional<CodeGroup> codeGroup = codeGroupRepository.findById(codeGroupId);

        if (codeGroup.isEmpty()) {
            throw new NotFoundException(ErrorCode.CODE_GROUP_NOT_FOUND);
        }

        codeGroupRepository.delete(codeGroup.get());
    }
}
