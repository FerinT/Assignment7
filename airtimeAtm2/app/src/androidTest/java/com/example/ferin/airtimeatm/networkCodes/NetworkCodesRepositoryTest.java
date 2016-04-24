package com.example.ferin.airtimeatm.networkCodes;

import android.test.AndroidTestCase;

import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;
import com.example.ferin.airtimeatm.repository.networkCodes.NetworkCodesRepository;
import com.example.ferin.airtimeatm.repository.networkCodes.impl.NetworkCodesRepositoryImpl;

import org.junit.Assert;

import java.util.Set;


/**
 * Created by Ferin on 2016-04-23.
 */
public class NetworkCodesRepositoryTest extends AndroidTestCase {

    private Long id;

    @org.junit.Test
    public void testCreateReadUpdateDelete() throws Exception {

        NetworkCodesRepository networkCodesRepository = new NetworkCodesRepositoryImpl(this.getContext());

        // CREATE
        NetworkCodes networkCodes = new NetworkCodes.Builder()
                .networkName("vodacom")
                .balanceEnquiry("*100#")
                .recharge("*100*01*P#")
                .transfer("*111#")
                .menu("*111#")
                .pcm("*140*Y#")
                .build();

        NetworkCodes insertedEntity = networkCodesRepository.save(networkCodes);
        id = insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

        // READ ALL
        Set<NetworkCodes> networkCodesSet = networkCodesRepository.findAll();
        Assert.assertTrue(networkCodesSet.size() > 0);

        // READ ENTITY
        NetworkCodes entity = networkCodesRepository.findById(id);
        Assert.assertNotNull(entity);

        // UPDATE ENTITY
        NetworkCodes updateEntity = new NetworkCodes.Builder()
                .copy(entity)
                .networkName("newName")
                .build();

        networkCodesRepository.update(updateEntity);
        NetworkCodes newEntity = networkCodesRepository.findById(id);
        Assert.assertEquals("newName", newEntity.getNetworkName());

        // DELETE ENTITY
        networkCodesRepository.delete(updateEntity);
        NetworkCodes deletedEntity = networkCodesRepository.findById(id);
        Assert.assertNull(deletedEntity);
    }

}
