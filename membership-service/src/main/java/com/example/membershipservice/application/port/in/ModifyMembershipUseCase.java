package com.example.membershipservice.application.port.in;

import com.example.membershipservice.domain.Membership;

public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand command);
}