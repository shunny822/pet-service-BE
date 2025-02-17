package com.alp_b.practice.codeGroup.controller;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.dto.CodeGroupListResponse;
import com.alp_b.practice.codeGroup.dto.CodeGroupResponse;
import com.alp_b.practice.codeGroup.dto.CreateCodeGroupRequest;
import com.alp_b.practice.codeGroup.service.CodeGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<String> createCodeGroup(
            @RequestBody @Valid CreateCodeGroupRequest createCodeGroupRequest
    ) {
        codeGroupService.createCodeGroup(createCodeGroupRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Code group is created successfully.");
    }

    @DeleteMapping("/{codeGroupId}")
    public ResponseEntity<String> deleteCodeGroup(@PathVariable Integer codeGroupId) {
        codeGroupService.deleteCodeGroup(codeGroupId);

        return ResponseEntity.ok("Code group is deleted successfully.");
    }
}
