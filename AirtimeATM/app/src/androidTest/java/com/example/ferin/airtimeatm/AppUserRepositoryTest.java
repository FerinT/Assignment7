package com.example.ferin.airtimeatm;

import android.test.AndroidTestCase;

import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.repository.appUser.AppUserRepository;
import com.example.ferin.airtimeatm.repository.appUser.impl.AppUserRepositoryImpl;

import org.junit.Assert;

/**
 * Created by Ferin on 2016-04-20.
 */
public class AppUserRepositoryTest  extends AndroidTestCase{

    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testDatabase() throws Exception {
        AppUserRepository appUserRepository = new AppUserRepositoryImpl(this.getContext());

        AppUser appUser = new AppUser.Builder()
                .cellphoneNumber("0810101966")
                .androidID("123")
                .build();

        AppUser insertedEntity = appUserRepository.save(appUser);

        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);
    }
}
