package com.example.ferin.airtimeatm.appUser;

import android.test.AndroidTestCase;

import com.example.ferin.airtimeatm.domain.appUser.AppUser;
import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;
import com.example.ferin.airtimeatm.repository.appUser.AppUserRepository;
import com.example.ferin.airtimeatm.repository.appUser.impl.AppUserRepositoryImpl;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Ferin on 2016-04-23.
 */
public class AppUserRepositoryTest extends AndroidTestCase{

    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        AppUserRepository appUserRepository = new AppUserRepositoryImpl(this.getContext());

        // CREATE
        CellphoneNetwork cellphoneNetwork = new CellphoneNetwork.Builder()
                .networkName("vodacom")
                .build();
        AppUser createEntity = new AppUser.Builder()
                .androidID("123")
                .cellphoneNumber("0810101966")
                .cellphoneNetwork(cellphoneNetwork)
                .build();
        AppUser insertedEntity = appUserRepository.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

        // READ ALL
        Set<AppUser> appUserSet = appUserRepository.findAll();
        Assert.assertTrue(appUserSet.size() >0);

        // READ ENTITY
        AppUser entity = appUserRepository.findById(id);
        Assert.assertNotNull(entity);

        // UPDATE ENTITY
        AppUser updateEntity = new AppUser.Builder()
                .copy(entity)
                .cellphoneNumber("0215516894")
                .build();
        appUserRepository.update(updateEntity);
        AppUser newEntity = appUserRepository.findById(id);
        Assert.assertEquals("0215516894", newEntity.getCellphoneNumber());

        // DELETE ENTITY
        appUserRepository.delete(updateEntity);
        AppUser deletedEntity = appUserRepository.findById(id);
        Assert.assertNull(deletedEntity);


        // DELETE ALL
        appUserRepository.deleteAll();
        Set<AppUser> deletedUsers = appUserRepository.findAll();
        Assert.assertTrue(deletedUsers.size() == 0);

    }
}
