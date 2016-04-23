package com.example.ferin.airtimeatm.factories.network;

import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;


public interface CellphoneNetworkFactory {
    CellphoneNetwork getCellphoneNetwork(String networkName,NetworkCodes networkCodes);
}
