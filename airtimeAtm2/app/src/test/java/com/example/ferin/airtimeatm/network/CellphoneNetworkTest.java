package com.example.ferin.airtimeatm.network;


import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;
import com.example.ferin.airtimeatm.factories.network.CellphoneNetworkFactoryImpl;

import org.junit.Assert;
import org.junit.Test;

public class CellphoneNetworkTest {

    @Test
    public void testCreate() throws Exception {
        CellphoneNetwork cellphoneNetwork = new CellphoneNetworkFactoryImpl().getCellphoneNetwork("vodacom", new NetworkCodes.Builder().build());

        Assert.assertNotNull(cellphoneNetwork.getNetworkCodes().getClass());

    }

    @Test
    public void testUpdate() throws Exception {
        CellphoneNetwork cellphoneNetwork = new CellphoneNetworkFactoryImpl().getCellphoneNetwork("vodacom", new NetworkCodes.Builder().build());

        CellphoneNetwork cellphoneNetwork1 = new CellphoneNetwork.Builder()
                .copy(cellphoneNetwork)

                .build();

        Assert.assertEquals(cellphoneNetwork1.getNetworkName(), cellphoneNetwork.getNetworkName());
    }

}
