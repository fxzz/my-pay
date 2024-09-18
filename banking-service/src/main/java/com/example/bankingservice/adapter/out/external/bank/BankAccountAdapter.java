package com.example.bankingservice.adapter.out.external.bank;


import com.example.bankingservice.application.port.out.RequestBankAccountInfoPort;
import com.example.common.ExternalSystemAdapter;


@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        /**
         *  1. 외부 은행에 http 통해서 실제 은행 계좌 정보를 가져오고
         *
         *  2. 실제 은행 계좌 -> BankAccount 파싱후 리턴
         */

        // 공부용이라 그대로 return
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
