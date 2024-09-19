package com.example.bankingservice.application.port.out;

import com.example.bankingservice.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.example.bankingservice.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
