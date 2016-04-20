package com.example.ferin.airtimeatm.factories.network;

import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

public class CellphoneNetworkFactoryImpl implements  CellphoneNetworkFactory{
    @Override
    public CellphoneNetwork getCellphoneNetwork(long id, String networkName) {
        CellphoneNetwork cellphoneNetwork  = new CellphoneNetwork.Builder()
                .id(id)
                .networkName(networkName)
                .networkCodes(networkName)
                .build();

        return cellphoneNetwork;
    }
}
