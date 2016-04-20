package com.example.ferin.airtimeatm.factories.networkCode;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

/**
 * Created by Ferin on 2016-04-16.
 */
public class VirginMobile extends NetworkCodeFactory {

    @Override
    public NetworkCodes getNetworkCodes() {

        NetworkCodes codes = new NetworkCodes.Builder()
                .balanceEnquiry("*101#")
                .recharge("*102*P#")
                .transfer("*106#")
                .menu("*100#")
                .pcm("*125*Y#")
                .build();

        return codes;
    }
}
