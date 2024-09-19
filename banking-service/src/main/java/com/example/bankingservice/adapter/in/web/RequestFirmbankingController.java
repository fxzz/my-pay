package com.example.bankingservice.adapter.in.web;

import com.example.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.example.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.example.bankingservice.application.port.in.RequestFirmbankingCommand;
import com.example.bankingservice.application.port.in.RequestFirmbankingUseCase;
import com.example.bankingservice.domain.FirmbankingRequest;
import com.example.bankingservice.domain.RegisteredBankAccount;
import com.example.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {

    private final RequestFirmbankingUseCase requestFirmbankingUseCase;

    @PostMapping(path = "/banking/firmbanking/request")
    FirmbankingRequest requestFirmbanking(@RequestBody RequestFirmbankingRequest request) {
        RequestFirmbankingCommand command = RequestFirmbankingCommand.builder()
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmbankingUseCase.requestFirmbanking(command);
    }
}