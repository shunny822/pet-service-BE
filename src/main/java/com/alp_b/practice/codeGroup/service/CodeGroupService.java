package com.alp_b.practice.codeGroup.service;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.dto.CreateCodeGroupRequest;

import java.util.List;

public interface CodeGroupService {
    List<CodeGroup> findAllCodeGroup();
    void createCodeGroup(CreateCodeGroupRequest createCodeGroupRequest);
    void deleteCodeGroup(Integer codeGroupId);
}
