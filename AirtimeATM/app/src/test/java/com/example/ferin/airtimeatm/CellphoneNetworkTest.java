package com.example.ferin.airtimeatm;


import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.factories.network.CellphoneNetworkFactoryImpl;
import com.example.ferin.airtimeatm.factories.networkCode.TelkomMobile;
import com.example.ferin.airtimeatm.factories.networkCode.Vodacom;

import org.junit.Assert;
import org.junit.Test;

public class CellphoneNetworkTest {

    @Test
    public void testCreate() throws Exception {
        CellphoneNetwork cellphoneNetwork = new CellphoneNetworkFactoryImpl().getCellphoneNetwork(1, "vodacom");

        Assert.assertEquals(cellphoneNetwork.getNetworkCodes().getClass(), new Vodacom().getNetworkCodes().getClass());

    }

    @Test
    public void testUpdate() throws Exception {
        CellphoneNetwork cellphoneNetwork = new CellphoneNetworkFactoryImpl().getCellphoneNetwork(1, "vodacom");

        CellphoneNetwork cellphoneNetwork1 = new CellphoneNetwork.Builder()
                .networkCodes("mtn")
                .networkName("mtn")
                .id(2)
                .copy(cellphoneNetwork)
                .build();

        Assert.assertEquals(cellphoneNetwork1.getNetworkCodes(), cellphoneNetwork.getNetworkCodes());
    }

    @Test
    public void testDifferentNetwork() throws Exception {
        CellphoneNetwork cellphoneNetwork = new CellphoneNetworkFactoryImpl().getCellphoneNetwork(1, "telkommobile");

        Assert.assertEquals(cellphoneNetwork.getNetworkCodes().getClass(), new TelkomMobile().getNetworkCodes().getClass());

    }
}
