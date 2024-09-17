package com.example.membershipservice.application.service;

import com.example.common.UseCase;
import com.example.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.example.membershipservice.adapter.out.persistence.MembershipMapper;
import com.example.membershipservice.application.port.in.FindMembershipCommand;
import com.example.membershipservice.application.port.in.FindMembershipUseCase;
import com.example.membershipservice.application.port.out.FindMembershipPort;
import com.example.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    private final MembershipMapper membershipMapper;
    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);
    }
}