package com.example.ferin.airtimeatm.factories.networkCode;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

public class CellC extends NetworkCodeFactory {

    @Override
    public  NetworkCodes getNetworkCodes() {

        NetworkCodes codes = new NetworkCodes.Builder()
                .balanceEnquiry("*101#")
                .recharge("*102*P#")
                .transfer("*147#")
                .menu("*147#")
                .pcm("*111*Y#")
                .build();

        return codes;
    }
}
