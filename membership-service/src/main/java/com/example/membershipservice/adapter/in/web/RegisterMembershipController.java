package com.example.membershipservice.adapter.in.web;

import com.example.common.WebAdapter;
import com.example.membershipservice.application.port.in.RegisterMembershipCommand;
import com.example.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.example.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        //request 값이 추가,변동되더라도 command라는 중간계층을 활용해서 쉽게 호환성을 맞추기 위해 사용
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
