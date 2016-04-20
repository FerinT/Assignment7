package com.example.ferin.airtimeatm.factories.network;

import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;

/**
 * Created by Ferin on 2016-04-16.
 */
public interface CellphoneNetworkFactory {
    CellphoneNetwork getCellphoneNetwork(long id, String networkName);
}
