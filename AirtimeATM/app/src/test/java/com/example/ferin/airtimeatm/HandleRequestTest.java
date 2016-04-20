package com.example.ferin.airtimeatm;


import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.factories.appUser.AppUserFactoryImpl;

import org.junit.Assert;
import org.junit.Test;

public class HandleRequestTest {

    @Test
    public void testCreate() throws Exception {
        AppUser appUser = new AppUserFactoryImpl().createAppUser("0810101966", "123", new CellphoneNetwork.Builder().networkName("vodacom").build());
        HandleRequest.getNetwork(appUser);

        Assert.assertEquals( HandleRequest.prepareString(2, "0810101966"), "*140*0810101966#");
    }

    @Test
    public void testDifferentNetwork() throws Exception {
        AppUser appUser = new AppUserFactoryImpl().createAppUser("0810101966", "123", new CellphoneNetwork.Builder().networkName("mtn").build());

        HandleRequest.getNetwork(appUser);

        Assert.assertEquals( HandleRequest.prepareString(0, ""), "*141#");

    }
}
