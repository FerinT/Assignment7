package com.example.ferin.airtimeatm.factories.networkCode;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

/**
 * Created by Ferin on 2016-04-16.
 */
public class TelkomMobile extends NetworkCodeFactory {

    @Override
    public NetworkCodes getNetworkCodes() {

        NetworkCodes codes = new NetworkCodes.Builder()
                .balanceEnquiry("*188#")
                .recharge("*188*P#")
                .transfer("*180#")
                .menu("*100#")
                .pcm("*140*Y#")
                .build();

        return codes;
    }

}
