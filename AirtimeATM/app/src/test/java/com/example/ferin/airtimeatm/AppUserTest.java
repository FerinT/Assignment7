package com.example.ferin.airtimeatm;

import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.factories.appUser.AppUserFactoryImpl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ferin on 2016-04-16.
 */
public class AppUserTest {
    @Test
    public void testCreate() throws Exception {
        AppUser appUser = new AppUserFactoryImpl().createAppUser("0810101966", "123", new CellphoneNetwork.Builder().build());
        Assert.assertEquals(appUser.getAndroidID(), "123");
    }

    @Test
    public void testUpdate() throws Exception {
        AppUser appUser = new AppUserFactoryImpl().createAppUser("0810101966", "123", new CellphoneNetwork.Builder().build());

        AppUser appUser1 = new AppUser.Builder()
                .androidID("456")
                .cellphoneNumber("0215516894")
                .copy(appUser)
                .build();

        Assert.assertEquals(appUser.getAndroidID(), appUser1.getAndroidID());
    }
}
