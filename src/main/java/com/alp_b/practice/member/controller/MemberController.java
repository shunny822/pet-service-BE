package com.alp_b.practice.member.controller;

import com.alp_b.practice.member.domain.Member;
import com.alp_b.practice.member.dto.CreateMemberRequest;
import com.alp_b.practice.member.dto.CreateMemberResponse;
import com.alp_b.practice.member.dto.FindMemberResponse;
import com.alp_b.practice.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<CreateMemberResponse> createMember(
            @RequestBody @Valid CreateMemberRequest createMemberRequest
    ) {
        Long memberId = memberService.createMember(createMemberRequest);
        CreateMemberResponse response = CreateMemberResponse.of(memberId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<FindMemberResponse> findMember(@PathVariable Long memberId) {
        Member member = memberService.getMember(memberId);

        return ResponseEntity.ok(FindMemberResponse.from(member));
    }
}
