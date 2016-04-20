package com.example.ferin.airtimeatm.factories.appUser;

import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;

/**
 * Created by Ferin on 2016-04-16.
 */
public interface AppUserFactory {
    AppUser createAppUser(String cellphoneNumber, String androidID, CellphoneNetwork cellphoneNetwork);
}
