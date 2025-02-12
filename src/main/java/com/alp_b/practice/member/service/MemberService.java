package com.alp_b.practice.member.service;

import com.alp_b.practice.member.domain.Member;
import com.alp_b.practice.member.dto.CreateMemberRequest;

public interface MemberService {
    Long createMember(CreateMemberRequest createMemberRequest);
    Member getMember(Long id);
}
