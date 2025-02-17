package com.alp_b.practice.codeDetail.service;

import com.alp_b.practice.codeDetail.domain.CodeDetail;
import com.alp_b.practice.codeDetail.dto.CreateCodeDetailRequest;

import java.util.List;

public interface CodeDetailService {
    List<CodeDetail> findAllCodeDetail();
    void createCodeDetial(CreateCodeDetailRequest createCodeDetailRequest);
}
