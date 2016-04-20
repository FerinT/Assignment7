package com.example.ferin.airtimeatm.factories.networkCode;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

/**
 * Created by Ferin on 2016-04-16.
 */
public class Mtn extends NetworkCodeFactory {

    @Override
    public NetworkCodes getNetworkCodes() {

        NetworkCodes codes = new NetworkCodes.Builder()
                .balanceEnquiry("*141#")
                .recharge("*141*P#")
                .transfer("*141*6328*AMT#")
                .menu("*141#")
                .pcm("*121*Y#")
                .build();

        return codes;
    }
}
