package com.example.bankingservice.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetBankAccountRequest {

    private String bankName;

    private String bankAccountNumber;
}
