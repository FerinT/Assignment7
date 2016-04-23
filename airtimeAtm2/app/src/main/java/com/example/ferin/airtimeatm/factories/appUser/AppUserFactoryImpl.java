package com.example.ferin.airtimeatm.factories.appUser;

import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;

/**
 * Created by Ferin on 2016-04-16.
 */
public class AppUserFactoryImpl implements AppUserFactory {

    @Override
    public AppUser createAppUser(String cellphoneNumber, String androidID, CellphoneNetwork cellphoneNetwork) {
        AppUser appUser = new AppUser.Builder()
                .androidID(androidID)
                .cellphoneNumber(cellphoneNumber)
                .cellphoneNetwork(cellphoneNetwork)
                .build();
        return appUser;
    }
}
