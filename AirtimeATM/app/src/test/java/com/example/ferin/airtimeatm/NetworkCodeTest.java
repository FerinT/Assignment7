package com.example.ferin.airtimeatm;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;
import com.example.ferin.airtimeatm.factories.networkCode.NetworkCodeFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ferin on 2016-04-16.
 */
public class NetworkCodeTest {
    @Test
    public void testCreate() throws Exception {
        NetworkCodes networkCodes = NetworkCodeFactory.returnNetworkCode("cellc");

        Assert.assertEquals(networkCodes.getMenu(), "*147#");
    }

    @Test
    public void testUpdate() throws Exception {
        NetworkCodes networkCodes = NetworkCodeFactory.returnNetworkCode("cellc");

        NetworkCodes networkCodes1 = new NetworkCodes.Builder()
                .copy(networkCodes)
                .balanceEnquiry("*100#")
                .build();

        Assert.assertEquals(networkCodes1.getBalanceEnquiry(), "*100#");

    }
}
