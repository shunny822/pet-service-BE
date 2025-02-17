package com.alp_b.practice.codeDetail.service.impl;

import com.alp_b.practice.codeDetail.domain.CodeDetail;
import com.alp_b.practice.codeDetail.repository.CodeDetailRepository;
import com.alp_b.practice.codeDetail.service.CodeDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CodeDetailServiceImpl implements CodeDetailService {
    private final CodeDetailRepository codeDetailRepository;


    @Override
    public List<CodeDetail> findAllCodeDetail() {
        return codeDetailRepository.findAll();
    }
}
