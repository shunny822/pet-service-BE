package com.alp_b.practice.codeDetail.controller;

import com.alp_b.practice.codeDetail.domain.CodeDetail;
import com.alp_b.practice.codeDetail.dto.CodeDetailListResponse;
import com.alp_b.practice.codeDetail.dto.CodeDetailResponse;
import com.alp_b.practice.codeDetail.dto.CreateCodeDetailRequest;
import com.alp_b.practice.codeDetail.service.CodeDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/code-detail")
public class CodeDetailController {
    private final CodeDetailService codeDetailService;

    @GetMapping
    public ResponseEntity<CodeDetailListResponse> findCodeDetails() {
        List<CodeDetail> codeDetails = codeDetailService.findAllCodeDetail();
        List<CodeDetailResponse> codeDetailResponses = new ArrayList<>();

        for (CodeDetail codeDetail : codeDetails) {
            codeDetailResponses.add(CodeDetailResponse.from(codeDetail));
        }

        return ResponseEntity.ok(new CodeDetailListResponse(codeDetailResponses));
    }

    @PostMapping
    public ResponseEntity<String> createCodeDetail(
            @RequestBody @Valid CreateCodeDetailRequest createCodeDetailRequest
    ) {
        codeDetailService.createCodeDetial(createCodeDetailRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Code detail is created successfully.");
    }
}
