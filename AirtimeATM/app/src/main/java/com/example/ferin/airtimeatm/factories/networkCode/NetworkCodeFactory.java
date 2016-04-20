package com.example.ferin.airtimeatm.factories.networkCode;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

/**
 * Created by Ferin on 2016-04-16.
 */
public abstract class NetworkCodeFactory {


    public  static NetworkCodes returnNetworkCode(String networkName)
    {
        if(networkName.equalsIgnoreCase("vodacom"))
            return new Vodacom().getNetworkCodes();
        if(networkName.equalsIgnoreCase("mtn"))
            return new Mtn().getNetworkCodes();
        if(networkName.equalsIgnoreCase("virginmobile"))
            return new VirginMobile().getNetworkCodes();
        if(networkName.equalsIgnoreCase("telkommobile"))
            return new TelkomMobile().getNetworkCodes();
        if(networkName.equalsIgnoreCase("cellc"))
            return new CellC().getNetworkCodes();

        else
        return null;
    }

    abstract NetworkCodes getNetworkCodes();
}
