package com.example.ferin.airtimeatm.domain.network;

import com.example.ferin.airtimeatm.domain.networkCode.NetworkCodes;
import com.example.ferin.airtimeatm.factories.networkCode.NetworkCodeFactory;

import java.io.Serializable;

/**
 * Created by Ferin on 2016-04-16.
 */
public class CellphoneNetwork implements Serializable{

    private long id;
    private String networkName;
    private NetworkCodes networkCodes;

    public long getId() {
        return id;
    }

    public String getNetworkName() {
        return networkName;
    }

    public NetworkCodes getNetworkCodes() {
        return networkCodes;
    }

    private CellphoneNetwork(){}

    private CellphoneNetwork(Builder builder)
    {
        this.id = builder.id;
        this.networkName = builder.networkName;
        this.networkCodes = builder.networkCodes;
    }

    public static class Builder
    {
        private long id;
        private String networkName;
        private NetworkCodes networkCodes;

        public Builder id(long id)
        {
            this.id = id;
            return  this;
        }

        public Builder networkName(String networkName)
        {
            this.networkName = networkName;
            return this;
        }

        public Builder networkCodes(String networkName)
        {
            this.networkCodes =  NetworkCodeFactory.returnNetworkCode(networkName);//networkCodes;
            return this;
        }

        public Builder copy(CellphoneNetwork cellphoneNetwork)
        {
            this.networkCodes = cellphoneNetwork.networkCodes;
            this.id = cellphoneNetwork.id;
            this.networkName = cellphoneNetwork.networkName;
            return this;
        }

        public CellphoneNetwork build() {
            return new CellphoneNetwork(this);
        }
    }
}
