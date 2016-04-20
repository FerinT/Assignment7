package com.example.ferin.airtimeatm.factories.networkCode;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

/**
 * Created by Ferin on 2016-04-16.
 */
public class Vodacom extends NetworkCodeFactory {

    @Override
    public NetworkCodes getNetworkCodes() {

        NetworkCodes codes = new NetworkCodes.Builder()
                .balanceEnquiry("*100#")
                .recharge("*100*01*P#")
                .transfer("*111#")
                .menu("*111#")
                .pcm("*140*Y#")
                .build();

        return codes;
    }
}
