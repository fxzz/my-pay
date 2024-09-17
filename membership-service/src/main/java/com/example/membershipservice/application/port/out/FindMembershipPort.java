package com.example.membershipservice.application.port.out;

import com.example.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.example.membershipservice.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}