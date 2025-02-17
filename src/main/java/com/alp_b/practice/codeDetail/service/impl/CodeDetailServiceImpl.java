package com.alp_b.practice.codeDetail.service.impl;

import com.alp_b.practice.codeDetail.domain.CodeDetail;
import com.alp_b.practice.codeDetail.dto.CreateCodeDetailRequest;
import com.alp_b.practice.codeDetail.repository.CodeDetailRepository;
import com.alp_b.practice.codeDetail.service.CodeDetailService;
import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.repository.CodeGroupRepository;
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
public class CodeDetailServiceImpl implements CodeDetailService {
    private final CodeDetailRepository codeDetailRepository;
    private final CodeGroupRepository codeGroupRepository;

    @Override
    public List<CodeDetail> findAllCodeDetail() {
        return codeDetailRepository.findAll();
    }

    @Override
    public void createCodeDetial(CreateCodeDetailRequest createCodeDetailRequest) {
        Optional<CodeGroup> codeGroup = codeGroupRepository.findById(createCodeDetailRequest.codeGroupId());

        if (codeGroup.isEmpty()) {
            throw new NotFoundException(ErrorCode.CODE_GROUP_NOT_FOUND);
        }

        CodeDetail codeDetail = CodeDetail.builder()
                .breed(createCodeDetailRequest.breed())
                .codeGroup(codeGroup.get())
                .build();

        codeDetailRepository.save(codeDetail);
    }
}
