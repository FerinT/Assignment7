package com.example.ferin.airtimeatm.domain.network;

import com.example.ferin.airtimeatm.domain.networkCodes.NetworkCodes;

import java.io.Serializable;

/**
 * Created by Ferin on 2016-04-16.
 */
public class CellphoneNetwork implements Serializable{

    private String networkName;
    private NetworkCodes networkCodes;


    public String getNetworkName() {
        return networkName;
    }

    public NetworkCodes getNetworkCodes() {
        return networkCodes;
    }

    private CellphoneNetwork(){}

    private CellphoneNetwork(Builder builder)
    {
        this.networkName = builder.networkName;
        this.networkCodes = builder.networkCodes;
    }

    public static class Builder
    {
        private String networkName;
        private NetworkCodes networkCodes;

        public Builder networkName(String networkName)
        {
            this.networkName = networkName;
            return this;
        }

        public Builder networkCodes(NetworkCodes networkCodes)
        {
            this.networkCodes = networkCodes;
            return this;
        }

        public Builder copy(CellphoneNetwork cellphoneNetwork)
        {
            this.networkCodes = cellphoneNetwork.networkCodes;
            this.networkName = cellphoneNetwork.networkName;
            return this;
        }

        public CellphoneNetwork build() {
            return new CellphoneNetwork(this);
        }
    }
}
