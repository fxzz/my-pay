package com.example.bankingservice.application.port.out;

import com.example.bankingservice.adapter.out.external.bank.BankAccount;
import com.example.bankingservice.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
