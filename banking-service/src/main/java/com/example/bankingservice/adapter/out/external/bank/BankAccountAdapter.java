package com.example.bankingservice.adapter.out.external.bank;


import com.example.bankingservice.application.port.out.RequestBankAccountInfoPort;
import com.example.bankingservice.application.port.out.RequestExternalFirmbankingPort;
import com.example.common.ExternalSystemAdapter;


@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {

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

    @Override
    public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {

        // 실제로 외부 은행에 http 통신을 통해서
        // 펌뱅킹 요청을 하고

        // 그 결과를 파싱싱

        return new FirmbankingResult(0);
    }
}
