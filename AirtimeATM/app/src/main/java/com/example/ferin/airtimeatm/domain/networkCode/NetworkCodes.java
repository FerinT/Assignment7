package com.example.ferin.airtimeatm.domain.networkCode;


import java.io.Serializable;

/**
 * Created by Ferin on 2016-04-16.
 */
public class NetworkCodes implements Serializable{

    private String balanceEnquiry;
    private String pcm;
    private String recharge;
    private String menu;
    private String transfer;


    private NetworkCodes(){}

    private NetworkCodes(Builder builder)
    {
        this.balanceEnquiry = builder.balanceEnquiry;
        this.pcm = builder.pcm;
        this.recharge = builder.recharge;
        this.menu = builder.menu;
        this.transfer = builder.transfer;
    }

    public String getBalanceEnquiry() {
        return balanceEnquiry;
    }

    public String getPcm() {
        return pcm;
    }

    public String getRecharge() {
        return recharge;
    }

    public String getMenu() {
        return menu;
    }

    public String getTransfer() {
        return transfer;
    }

    public static class Builder
    {
        private String balanceEnquiry;
        private String pcm;
        private String recharge;
        private String menu;
        private String transfer;

        public Builder balanceEnquiry(String balanceEnquiry)
        {
            this.balanceEnquiry = balanceEnquiry;
            return this;
        }

        public Builder pcm(String pcm)
        {
            this.pcm = pcm;
            return this;
        }

        public Builder recharge(String recharge)
        {
            this.recharge = recharge;
            return this;
        }

        public Builder menu(String menu)
        {
            this.menu = menu;
            return this;
        }

        public Builder transfer(String transfer)
        {
            this.transfer = transfer;
            return this;
        }

        public Builder copy(NetworkCodes networkCodes)
        {
            this.balanceEnquiry = networkCodes.balanceEnquiry;
            this.pcm = networkCodes.pcm;
            this.recharge = networkCodes.recharge;
            this.menu = networkCodes.menu;
            this.transfer = networkCodes.transfer;

            return this;
        }

        public NetworkCodes build()
        {
            return new NetworkCodes(this);
        }
    }
}
