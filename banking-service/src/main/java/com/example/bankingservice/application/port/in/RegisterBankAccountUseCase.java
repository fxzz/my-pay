package com.example.bankingservice.application.port.in;

import com.example.bankingservice.domain.RegisteredBankAccount;
import com.example.common.UseCase;



@UseCase
public interface RegisterBankAccountUseCase {
    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}