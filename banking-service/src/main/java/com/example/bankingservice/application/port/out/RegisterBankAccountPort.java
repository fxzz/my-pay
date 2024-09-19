package com.example.bankingservice.application.port.out;


import com.example.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.example.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {
    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
