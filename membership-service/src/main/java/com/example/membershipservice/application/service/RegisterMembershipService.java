package com.example.membershipservice.application.service;

import com.example.common.UseCase;
import com.example.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.example.membershipservice.adapter.out.persistence.MembershipMapper;
import com.example.membershipservice.application.port.in.RegisterMembershipCommand;
import com.example.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.example.membershipservice.application.port.out.RegisterMembershipPort;
import com.example.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
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
