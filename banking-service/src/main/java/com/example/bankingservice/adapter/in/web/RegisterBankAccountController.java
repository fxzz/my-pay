package com.example.bankingservice.adapter.in.web;

import com.example.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.example.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.example.bankingservice.domain.RegisteredBankAccount;
import com.example.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//테스트1

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {

        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        if (registeredBankAccount == null) {
            // TODO: Error Handling
            return null;
        }
        return registeredBankAccount;
    }
}
