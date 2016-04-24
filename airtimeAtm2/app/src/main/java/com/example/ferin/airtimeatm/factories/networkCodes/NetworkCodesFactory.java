package com.example.ferin.airtimeatm.factories.networkCodes;

import android.content.Context;

import com.example.ferin.airtimeatm.conf.util.App;
import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;
import com.example.ferin.airtimeatm.repository.networkCodes.NetworkCodesRepository;
import com.example.ferin.airtimeatm.repository.networkCodes.impl.NetworkCodesRepositoryImpl;

/**
 * Created by Ferin on 2016-04-24.
 */
public abstract class NetworkCodesFactory {

    NetworkCodesRepository networkCodesRepository = new NetworkCodesRepositoryImpl(App.getInstance());
    NetworkCodes networkCodes;

    public  NetworkCodes getNetworkCode(String networkName)
    {
        //retrieve network codes from database
        if(networkName.equalsIgnoreCase("vodacom"))
            networkCodes = networkCodesRepository.findById(new Long(1));
        if(networkName.equalsIgnoreCase("mtn"))
            networkCodes = networkCodesRepository.findById(new Long(2));
        if(networkName.equalsIgnoreCase("cellc"))
            networkCodes = networkCodesRepository.findById(new Long(3));
        if(networkName.equalsIgnoreCase("telkomMobile"))
            networkCodes = networkCodesRepository.findById(new Long(4));
        if(networkName.equalsIgnoreCase("virginMobile"))
            networkCodes = networkCodesRepository.findById(new Long(5));

     return networkCodes;
    }
}
