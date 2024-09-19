package com.example.bankingservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//test2
// test3
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean isValid;
}
