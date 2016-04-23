package com.example.ferin.airtimeatm.factories.network;

import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;

public class CellphoneNetworkFactoryImpl implements CellphoneNetworkFactory {
    @Override
    public CellphoneNetwork getCellphoneNetwork(String networkName, NetworkCodes networkCodes) {
        CellphoneNetwork cellphoneNetwork  = new CellphoneNetwork.Builder()
                .networkName(networkName)
                .networkCodes(networkCodes)
                .build();

        return cellphoneNetwork;
    }
}
