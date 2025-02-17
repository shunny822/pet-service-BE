package com.alp_b.practice.codeGroup.controller;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.dto.CodeGroupListResponse;
import com.alp_b.practice.codeGroup.dto.CodeGroupResponse;
import com.alp_b.practice.codeGroup.service.CodeGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/code-group")
public class CodeGroupController {
    private final CodeGroupService codeGroupService;

    @GetMapping
    public ResponseEntity<CodeGroupListResponse> findCodeGroups() {
        List<CodeGroup> codeGroups = codeGroupService.findAllCodeGroup();
        List<CodeGroupResponse> responses = new ArrayList<>();

        for (CodeGroup codeGroup : codeGroups) {
            responses.add(CodeGroupResponse.from(codeGroup));
        }

        return ResponseEntity.ok(new CodeGroupListResponse(responses));
    }
}
