package com.example.membershipservice.application.service;

import com.example.common.UseCase;
import com.example.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.example.membershipservice.adapter.out.persistence.MembershipMapper;
import com.example.membershipservice.application.port.in.ModifyMembershipCommand;
import com.example.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.example.membershipservice.application.port.out.ModifyMembershipPort;
import com.example.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        // entity -> Membership
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}