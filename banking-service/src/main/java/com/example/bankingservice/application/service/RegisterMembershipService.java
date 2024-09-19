package com.example.bankingservice.application.service;

import com.example.bankingservice.adapter.out.external.bank.BankAccount;
import com.example.bankingservice.adapter.out.external.bank.GetBankAccountRequest;
import com.example.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.example.bankingservice.adapter.out.persistence.RegisteredBankAccountMapper;
import com.example.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.example.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.example.bankingservice.application.port.out.RegisterBankAccountPort;
import com.example.bankingservice.application.port.out.RequestBankAccountInfoPort;
import com.example.bankingservice.domain.RegisteredBankAccount;
import com.example.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;


    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비스
        // 1. 외부의 은행에 이 계좌가 정상인지 확인
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        // 2. 등록가능한 계좌라면 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면 에러를 리턴
        if (accountIsValid) {
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()+""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );
            return registeredBankAccountMapper.mapToDomainEntity(savedAccountInfo);
        } else {
            return null;
        }
    }
}
